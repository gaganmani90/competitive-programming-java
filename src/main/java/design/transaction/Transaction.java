package design.transaction;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
class Transaction {
    String card_country, ip_country, currency;
    long amount;
    List<Rule> rules;

    //CHARGE:card_country=US&currency=USD&amount=2500&ip_country=CA
    public Transaction(String record) {
        setAttributes(record.split("&"));
        rules = new ArrayList<>();
        log.info("Transaction created with {} rules: {}", rules.size(), this);
    }

    private void setAttributes(String[] arr) {
        for (String keyValue : arr) {
            String key = keyValue.split("=")[0];
            String value = keyValue.split("=")[1];

            if (TransactionValidityChecker.isValidKey(key)) {
                setAttribute(key, value);
            }
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "card_country='" + card_country + '\'' +
                ", ip_country='" + ip_country + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", rules=" + rules +
                '}';
    }

    private void setAttribute(String key, String value) {
        TransactionValidityChecker.ValidAttributes validKeys = TransactionValidityChecker.ValidAttributes.valueOf(TransactionValidityChecker.ValidAttributes.class, key.toUpperCase());
        switch (validKeys) {
            case AMOUNT -> this.amount = StringUtils.isEmpty(value) ? -1 : Long.parseLong(value);
            case CURRENCY -> this.currency = value;
            case IP_COUNTRY -> this.ip_country = value;
            case CARD_COUNTRY -> this.card_country = value;
        }
    }

    public boolean isValid() {
        log.info("START: isValid() transaction");
        boolean isValid = false;
        List<Boolean> allowed = new ArrayList<>();
        List<Boolean> blocked = new ArrayList<>();
        if (this.rules.size() == 0) {
            return true;
        } else {
            for (Rule rule : this.rules) {
                log.info("Processing Rule: {}", rule);
                if (rule.type.equals(Rule.RuleType.ALLOW)) {
                    populateRuleResults(allowed, rule);

                    if(rule.choice.equals(Rule.RuleChoice.AND)) {
                        isValid = allowed.contains(false) ? false : true;
                        if(!isValid) return false;
                    } else { //OR
                        isValid = allowed.contains(true);
                    }
                } else {
                    populateRuleResults(blocked, rule);

                    if(rule.choice.equals(Rule.RuleChoice.AND)) {
                        isValid = allowed.contains(true) ? false: true; //all block statements must be true to invalidate transaction
                        if(!isValid) return false;
                    } else {
                        isValid = allowed.contains(true) ? false: true; //one block is enough to invalidate
                    }
                }
            }
        }
        log.info("END: isValid() transaction - {}", isValid);
        return isValid;
    }

    private void populateRuleResults(List<Boolean> allowedOrBlocked, Rule rule) {
        if (!StringUtils.isEmpty(this.card_country)) {
            allowedOrBlocked.add(rule.evaluateCountry(this.card_country));
        }
        if (!StringUtils.isEmpty(this.ip_country)) {
            allowedOrBlocked.add(rule.evaluateIpCountry(this.ip_country));
        }
        if (!StringUtils.isEmpty(this.currency)) {
            allowedOrBlocked.add(rule.evaluateCurrency(this.currency));
        }
        if (this.amount != -1) {
            allowedOrBlocked.add(rule.evaluate(this.amount));
        }
    }

}

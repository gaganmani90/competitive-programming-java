package design.transaction;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
class Rule {
    final static List<String> operators = List.of("==","!=",">",">=","<=","<");

    enum RuleType {
        ALLOW, BLOCK
    }

    enum RuleChoice {
        AND, OR
    }

    RuleType type;
    RuleChoice choice;
    List<RuleProperty<String>> country, currency, ip_country;
    List<RuleProperty<Long>> amount;

    public Rule() {
        country = new ArrayList<>();
        currency = new ArrayList<>();
        ip_country = new ArrayList<>();
        amount = new ArrayList<>();
    }

    public void setType(String group) {
        if (this.type != null) return;
        if (group.startsWith(TransactionValidityChecker.ValidAttributes.ALLOW.value)) {
            this.type = RuleType.ALLOW;
        } else {
            this.type = RuleType.BLOCK;
        }
        log.info("Rule type: {}", this.type.toString());
    }

    public boolean evaluate(Long amount) {
        boolean isValid = true;
        for (RuleProperty<Long> prop : this.amount) {
            isValid = prop.apply(amount);
        }
        log.info("Rule Evaluate Completed. Amount {}: {}, {}", amount, isValid, this.amount);
        return isValid;
    }

    public boolean evaluateCountry(String actualCounty) {
        return evaluate(actualCounty, this.country);
    }

    public boolean evaluateCurrency(String actualCurrency) {
        return evaluate(actualCurrency, this.currency);
    }

    public boolean evaluateIpCountry(String actualIpCountry) {
        return evaluate(actualIpCountry, this.ip_country);
    }

    private boolean evaluate(String actualValue, List<RuleProperty<String>> properties) {
        boolean isValid = true;
        for (RuleProperty<String> prop : properties) {
            isValid = prop.apply(actualValue);
        }
        log.info("Rule Evaluate Completed. Actual value: {}, result: {}, {}", actualValue, isValid, properties);
        return isValid;
    }

    public String[] setChoice(String group) {
        String[] values;
        if (group.contains("AND")) {
            this.choice = RuleChoice.AND;
            values = group.split("AND");
        } else {
            this.choice = RuleChoice.OR;
            values = group.split("OR");
        }
        log.info("Rule Choice: {}, Split values: {}", this.choice, Arrays.toString(values));
        setComparableValuesAndOperators(values);
        return values;
    }

    /**
     * i.e. [card_country=US, ...]
     *
     * @param props
     */
    private void setComparableValuesAndOperators(String[] props) {
        log.info("Rule Props: {}", Arrays.toString(props));
        for (String prop : props) {
            for (String operator : operators) {
                if (prop.contains(operator)) { //required to know how to split
                    String[] parts = prop.split(operator);
                    TransactionValidityChecker.ValidAttributes validKeys = TransactionValidityChecker.ValidAttributes.valueOf(TransactionValidityChecker.ValidAttributes.class,
                            parts[0].toUpperCase());
                    switch (validKeys) {
                        case AMOUNT -> {
                            this.amount.add(new RuleProperty<Long>(parts[0], Long.parseLong(parts[1]), operator));
                            break;
                        }
                        case CURRENCY -> {
                            this.currency.add(new RuleProperty<String>(parts[0], parts[1], operator));
                            break;
                        }
                        case IP_COUNTRY -> {
                            this.ip_country.add(new RuleProperty<String>(parts[0], parts[1], operator));
                            break;
                        }
                        case CARD_COUNTRY -> {
                            this.country.add(new RuleProperty<String>(parts[0], parts[1], operator));
                            break;
                        }
                    }
                }
            }
        }
        log.info("Rule Props added, {} \n {} \n {} \n {}", this.amount, this.country, this.ip_country, this.currency);
    }

    @Override
    public String toString() {
        return "Rule{" +
                "type=" + type +
                ", choice=" + choice +
                ", country=" + country +
                ", currency=" + currency +
                ", ip_country=" + ip_country +
                ", amount=" + amount +
                '}';
    }
}

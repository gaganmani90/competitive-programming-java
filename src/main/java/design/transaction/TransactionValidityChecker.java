package design.transaction;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Having the AND/OR in the ALLOW/BLOCK list makes this more challenging.
 * <p>
 * https://github.com/Molakim/stripeCoding
 * https://leetcode.com/discuss/interview-question/1000714/Stripe-Interview-Question-Help
 * <p>
 * String charge = "["CHARGE:card_country=US&currency=USD&amount=250&ip_country=CA","ALLOW:amount>500", ]"
 * <p>
 * the algorithm has to return 1 of the transaction is allowed and 0 if not.
 * We have 2 different family rules : ALLOW and BLOCK, and both of them can accept up to 2 rules separated by an OR or an AND.
 * We have 6 different operations ( >, <, >=, <=, ==, !=)
 */
@Slf4j
public class TransactionValidityChecker {

    enum ValidAttributes {
        CARD_COUNTRY("card_country"),
        CURRENCY("currency"),
        AMOUNT("amount"),
        IP_COUNTRY("ip_country"),
        CHARGE("CHARGE"),
        ALLOW("ALLOW"),
        BLOCK("BLOCK");

        ValidAttributes(String value) {
            this.value = value;
        }

        String value;
    }

    public static boolean isValidTransaction(String record) {
        log.info("Record: {}", record);

        record = cleanUp(record);

        log.info("Post cleanup: {}", record);

        String[] groups = record.split(",");

        log.info("Processing {} groups: {}", groups.length, Arrays.toString(groups));

        Transaction transaction = null;
        for (String group : groups) {

            if (group.startsWith(ValidAttributes.CHARGE.value)) {
                transaction = new Transaction(group.split(":")[1]);
            } else if (group.startsWith(ValidAttributes.ALLOW.value)
                    || group.startsWith(ValidAttributes.BLOCK.value)) {
                log.info("CREATE RULE");
                Rule rule = new Rule();
                rule.setType(group);
                String ruleString = group.substring(group.indexOf(":") + 1); //remove ALLOW:, BLOCK:
                rule.setChoice(ruleString); //AND || OR. only one can happen

                transaction.rules.add(rule);
                log.info("CREATE RULE COMPLETED");
            }

        }
        System.out.println(transaction);
        return transaction.isValid();
    }

    public static boolean isValidKey(String key) {
        try {
            List<ValidAttributes> validAttributesList = EnumUtils.getEnumList(ValidAttributes.class);
            for (ValidAttributes attributes : validAttributesList) {
                if (key.equals(attributes.value)) {
                    return true;
                }
            }

        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static String cleanUp(String record) {
        return record.replace("[", "")
                .replace("]", "")
                .replace("\"", "").trim();
    }
}


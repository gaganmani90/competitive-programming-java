package design.transaction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionValidityCheckerTest {

    @Test
    void isValidTransaction() {
        String charge = "[\"CHARGE:card_country=US&currency=USD&amount=2500&ip_country=CA\",\"ALLOW:amount>500ANDip_country==CA\",\"BLOCK:card_country==CAORcard_country==MA\",  ]\n";
        String charge1 = "[\"CHARGE:card_country=US&currency=USD&amount=2500&ip_country=CA\",\"ALLOW:amount>500ANDip_country==CA\",\"BLOCK:card_country==USANDamount<200\",  ]\n";
        String charge2 = "[\"CHARGE:card_country=US&currency=USD&amount=2500&ip_country=CA\",\"ALLOW:currency==EUR\",  ]\n";
        String charge3 = "[\"CHARGE:card_country=US&currency=USD&amount=2500&ip_country=CA\",\"BLOCK:amount>500\",  ]\n";
        String charge4 = "[\"CHARGE:card_country=US&currency=USD&amount=2500&ip_country=CA\",\"ALLOW:amount>500ANDamount<2501\",  ]\n";
        String charge5 = "[\"CHARGE:card_country=US&currency=USD&amount=505&ip_country=CA\",\"ALLOW:amount>500ANDip_country==CA\",\"BLOCK:card_country==CAANDamount<200\",  ]\n";
        String charge6 = "[\"CHARGE:card_country=US&currency=USD&amount=505&ip_country=CA\",\"ALLOW:amount>500ANDamount==999ANDip_country==CA\",\"BLOCK:card_country==MAANDamount<200\",  ]\n";
        String charge7 = "[\"CHARGE:card_country=US&currency=USD&amount=999&ip_country=CA\",\"ALLOW:amount>500ANDamount==999ANDip_country==CA\",\"BLOCK:card_country==MAANDamount<200\",  ]\n";

        Assertions.assertEquals("CHARGE:card_country=US&currency=USD&amount=2500&ip_country=CA,BLOCK:amount>500,", TransactionValidityChecker.cleanUp(charge3));

        Assertions.assertTrue(TransactionValidityChecker.isValidTransaction(charge)); //TODO: fix test case
        Assertions.assertFalse(TransactionValidityChecker.isValidTransaction(charge1));
        Assertions.assertFalse(TransactionValidityChecker.isValidTransaction(charge2));
        Assertions.assertFalse(TransactionValidityChecker.isValidTransaction(charge3));
        Assertions.assertTrue(TransactionValidityChecker.isValidTransaction(charge4));
        Assertions.assertTrue(TransactionValidityChecker.isValidTransaction(charge5));
        Assertions.assertFalse(TransactionValidityChecker.isValidTransaction(charge6));
        Assertions.assertTrue(TransactionValidityChecker.isValidTransaction(charge7));
    }
}
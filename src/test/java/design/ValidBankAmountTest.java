package design;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ValidBankAmountTest {

    @Test
    void completeTransfer() {
        // Assertions.assertTrue(ProblemStatement.isGood());
        Map<String, Long> input = Map.of(
                "AU", 80L,
                "US", 140L,
                "MX", 110L,
                "SG", 120L,
                "FR", 70L
        );
        List<Account> accounts = ValidBankAmount.completeTransfer(input);

        for(Account account : accounts) {
            Assertions.assertTrue(account.isAccountValid(100L));
        }
    }
}
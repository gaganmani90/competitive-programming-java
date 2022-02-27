package design;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * At Stripe we keep track of where the money is and move money between bank accounts to make sure their balances are not below some threshold.
 * This is for operational and regulatory reasons, e.g. we should have enough funds to pay out to our users, and we are legally required to separate our users' funds from our own.
 * This interview question is a simplified version of a real-world problem we have here.
 * <p>
 * Let's say there are at most 500 bank accounts, some of their balances are above 100 and some are below. How do you move money between them so that they all have at least 100?
 * <p>
 * Just to be clear we are not looking for the optimal solution, but a working one.
 * <p>
 * Example input:
 * - AU: 80
 * - US: 140
 * - MX: 110
 * - SG: 120
 * - FR: 70
 * <p>
 * Output:
 * - from: US, to: AU, amount: 20
 * - from: US, to: FR, amount: 20
 * - from: MX, to: FR, amount: 10
 */
public class ValidBankAmount {
    final static long THRESHOLD = 100;

    public static List<Account> completeTransfer(Map<String, Long> accounts) {
        List<Account> fromAccounts = thresholdAccounts(accounts, THRESHOLD, false);
        List<Account> toAccounts = thresholdAccounts(accounts, THRESHOLD, true);

        executeTransfer(fromAccounts, toAccounts); //updates accounts

        return mergeAccounts(fromAccounts, toAccounts);

    }

    private static List<Account> mergeAccounts(List<Account> fromAccounts, List<Account> toAccounts) {
        final List<Account> finalAccounts = new ArrayList<>();
        for(Account account : fromAccounts) {
            finalAccounts.add(account);
        }
        for(Account account : toAccounts) {
            finalAccounts.add(account);
        }
        return finalAccounts;
    }

    private static void executeTransfer(List<Account> fromAccounts, List<Account> toAccounts) {
        for(Account fromAccount : fromAccounts) {
            for(Account toAccount: toAccounts) {
                if(toAccount.amount >= THRESHOLD) continue;
                long moneyNeeded = THRESHOLD - toAccount.amount;
                long moneyToTransfer = fromAccount.amount - moneyNeeded >= THRESHOLD ? moneyNeeded : fromAccount.amount - THRESHOLD;
                fromAccount.transferTo(toAccount, moneyToTransfer);
            }
        }
    }

    /**
     *
     * @param accounts
     * @param threshold
     * @return
     */
    static List<Account> thresholdAccounts(Map<String, Long> accounts, long threshold, boolean isBelow) {
        List<Account> accountsList = new ArrayList<>();
        for (String name : accounts.keySet()) {
            long amount = accounts.get(name);
            if (isBelow) {
                if (amount < threshold) {
                    accountsList.add(new Account(name, amount));
                }
            } else {
                if (amount >= threshold) {
                    accountsList.add(new Account(name, amount));
                }
            }
        }
        return accountsList;
    }
}

class Account implements Comparable<Account> {
    String name;
    long amount;

    public Account(String name, long amount) {
        this.name = name;
        this.amount = amount;
    }

    public void transferTo(Account account, long amount) {
        System.out.println("from: "+this.name+" to: "+account.name+" amount: "+amount);
        if (this.amount >= amount) {
            this.amount -= amount;
            account.amount += amount;
        }
    }

    @Override
    public int compareTo(Account o) {
        if (this.amount > o.amount) {
            return 1;
        } else if (this.amount < o.amount) {
            return -1;
        } else {
            return 0;
        }
    }

    public boolean isAccountValid(long threshold) {
        return this.amount >= threshold;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}

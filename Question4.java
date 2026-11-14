/**
 * Category C · Practice Problems
 * Problem 4: Payment Processing
 * 
 * TASK:
 * A shop accepts cash, card and UPI payments. Card payments carry a 2% fee; cash and UPI carry none.
 * 
 * Define an interface PaymentMode with double processPayment(double amount) and implement it in
 * CashPayment, CardPayment and UpiPayment. Store the payments in one PaymentMode[] array, print
 * each payment's details and the total processed.
 * 
 * INPUT / OUTPUT:
 * Input: The number of payments, then each mode and amount.
 * Output: mode: amount a, fee f, processed p for each payment, then the total.
 * 
 * COMPLEXITY:
 * - Time Complexity: O(n) where n is the number of payments.
 * - Space Complexity: O(n) auxiliary space to store payments.
 */
public class Question4 {

    public interface PaymentMode {
        double processPayment(double amount);
        double getFee(double amount);
        String getModeName();
    }

    public static class CashPayment implements PaymentMode {
        @Override
        public double getFee(double amount) {
            return 0.0;
        }

        @Override
        public double processPayment(double amount) {
            return amount + getFee(amount);
        }

        @Override
        public String getModeName() {
            return "Cash";
        }
    }

    public static class CardPayment implements PaymentMode {
        @Override
        public double getFee(double amount) {
            return amount * 0.02; // 2% fee
        }

        @Override
        public double processPayment(double amount) {
            return amount + getFee(amount);
        }

        @Override
        public String getModeName() {
            return "Card";
        }
    }

    public static class UpiPayment implements PaymentMode {
        @Override
        public double getFee(double amount) {
            return 0.0;
        }

        @Override
        public double processPayment(double amount) {
            return amount + getFee(amount);
        }

        @Override
        public String getModeName() {
            return "UPI";
        }
    }

    public static class Transaction {
        PaymentMode mode;
        double amount;

        public Transaction(PaymentMode mode, double amount) {
            this.mode = mode;
            this.amount = amount;
        }
    }

    public static void processAllPayments(Transaction[] transactions) {
        if (transactions == null || transactions.length == 0) {
            System.out.println("Total Amount Processed: 0.0");
            return;
        }

        double totalProcessed = 0.0;
        for (Transaction txn : transactions) {
            double fee = txn.mode.getFee(txn.amount);
            double processed = txn.mode.processPayment(txn.amount);
            totalProcessed += processed;
            System.out.printf("%s: amount %.1f, fee %.1f, processed %.1f%n",
                txn.mode.getModeName(), txn.amount, fee, processed);
        }

        System.out.printf("Total Amount Processed: %.1f%n", totalProcessed);
    }

    public static void main(String[] args) {
        System.out.println("--- Sample Execution ---");
        Transaction[] transactions = {
            new Transaction(new CashPayment(), 1000),
            new Transaction(new CardPayment(), 2000),
            new Transaction(new UpiPayment(), 1500),
            new Transaction(new CardPayment(), 3000)
        };

        processAllPayments(transactions);

        System.out.println("\n--- Custom Test Case ---");
        Transaction[] customTxns = {
            new Transaction(new CardPayment(), 5000), // Fee 100, processed 5100
            new Transaction(new CashPayment(), 2500), // Fee 0, processed 2500
            new Transaction(new UpiPayment(), 4000)   // Fee 0, processed 4000
        };
        processAllPayments(customTxns);
    }
}

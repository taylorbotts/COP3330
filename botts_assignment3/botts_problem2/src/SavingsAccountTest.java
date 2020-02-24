public class SavingsAccountTest {

    public static void main(String[] args){

        SavingsAccount acc1 = new SavingsAccount(2000.00);
        SavingsAccount acc2 = new SavingsAccount(3000.00);

        SavingsAccount.modifyInterestRate(.04);

        for (int i = 1; i <= 12; i++){
            System.out.printf("Account 1 balance after %d month(s) at 4%%: $%.2f\n",
                                i, acc1.calculateMonthlyInterest());

            System.out.printf("Account 1 balance after %d month(s) at 4%%: $%.2f\n\n",
                                i, acc2.calculateMonthlyInterest());

        }

        SavingsAccount.modifyInterestRate(.05);

        System.out.printf("Account 1 balance after one more month at 5%%: $%.2f\n",
                acc1.calculateMonthlyInterest());

        System.out.printf("Account 2 balance after one more month at 5%%: $%.2f\n",
                acc2.calculateMonthlyInterest());

    }
}

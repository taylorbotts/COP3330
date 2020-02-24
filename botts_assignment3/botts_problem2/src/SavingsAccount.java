public class SavingsAccount {

    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double balance){
        savingsBalance = balance;
    }

    public double calculateMonthlyInterest(){
        double interest = savingsBalance * (annualInterestRate / 12);
        savingsBalance += interest;
        return savingsBalance;
    }

    public static void modifyInterestRate(double n){
        annualInterestRate = n;
    }


}

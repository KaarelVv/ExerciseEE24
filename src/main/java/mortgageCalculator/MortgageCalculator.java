package mortgageCalculator;

public class MortgageCalculator {
    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte PERCENT = 100;
    private int  amountOfMoney;
    private  float annualInterest;
    private short years;
    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month < balances.length; month++)
            balances[month-1]= calculateBalance(month);
        return balances;
    }
    public MortgageCalculator(int amountOfMoney, float annualInterest, byte years) {
        this.amountOfMoney = amountOfMoney;
        this.annualInterest = annualInterest;
        this.years = years;
    }
    public double calculateMortgage() {
        short numberOfPayments = getNumberOfPayments();
        float monthlyInterestRate = getMonthlyInterestRate();

        double mortgage = amountOfMoney * ((monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), numberOfPayments)))
                / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1));
        return mortgage;
    }
    public double calculateBalance(short numberOfPaymentsMade) {
        short numberOfPayments = getNumberOfPayments();
        float monthlyInterestRate = getMonthlyInterestRate();

        double remainingLoan = amountOfMoney * (((Math.pow((1 + monthlyInterestRate), numberOfPayments))
                - (Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))) / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1));
        return remainingLoan;
    }
    private short getNumberOfPayments() {
        return (short) (years * MONTHS_IN_YEAR);
    }
    private float getMonthlyInterestRate() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }


}

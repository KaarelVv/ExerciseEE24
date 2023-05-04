package mortageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Calculator {

    static final byte MONTHS_IN_YEAR = 12;
    static final byte PERCENT = 100;

    public static double calculateMortgage(int amountOfMoney, float annualInterest, byte years){
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        float monthlyInterestRate = annualInterest / PERCENT / MONTHS_IN_YEAR;

        double mortgage = amountOfMoney * ((monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), numberOfPayments)))
                / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1));
        return mortgage;
    }
    public static double calculateBalance(int amountOfMoney, float annualInterest, byte years, short numberOfPaymentsMade){
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        float monthlyInterestRate = annualInterest / PERCENT / MONTHS_IN_YEAR;

            double remainingLoan = amountOfMoney*(((Math.pow((1+monthlyInterestRate),numberOfPayments))
                    -(Math.pow(1+monthlyInterestRate,numberOfPaymentsMade)))/(Math.pow((1+monthlyInterestRate),numberOfPayments)-1));
            return  remainingLoan;
    }
    public static double readNumber(String prompt, double min, double max ){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >=min && value <= max)
                break;
            System.out.println("Enter value between" + min + "-" + max);
        }
        return value;
    }
    public static void printMonthlyPayment(int principal, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("Mortgage");
        System.out.println("--------");
        System.out.println("Monthly Payments :" + mortgageFormatted);
    }
    public static void printPaymentSchedule(int principal, float annualInterest, double years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++){
            double balance = calculateBalance(principal, annualInterest, (byte) years,month);
            String balanceFormatted = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(balanceFormatted);

        }
    }
}

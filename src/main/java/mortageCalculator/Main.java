package mortageCalculator;

import java.text.NumberFormat;

import static mortageCalculator.Calculator.*;

public class Main {

    public static void main(String[] args) {


        double principal = readNumber("Principal :", 1000, 1_000_000);
        double annualInterest = readNumber("Interest Rate :", 1, 30);
        double years = readNumber("Period of years :", 1, 30);
        printMonthlyPayment((int) principal, (float) annualInterest, (byte) years);
        printPaymentSchedule((int) principal, (float) annualInterest, years);
    }




}

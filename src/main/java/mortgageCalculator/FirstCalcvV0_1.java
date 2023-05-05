package mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class FirstCalcvV0_1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int amountOfMoney = 0;
        byte years = 0;
        float monthlyInterestRate = 0;
        int numberOfPayments = 0;
        int numberOfPaymentsMadeInYears = 0;

        while (true) {
            System.out.print("Amount of loan (1k -1M) :");
            amountOfMoney = scanner.nextInt();
            if (amountOfMoney >= 1000 && amountOfMoney <= 1_000_000)
                break;
            System.out.println("Enter the value of loan between 1K -1M");
        }
        while (true) {
            System.out.print("Annual interest rate :");
            float annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >=1 && annualInterestRate <= 30){
                monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter value between 1 - 30");
        }
        while (true) {
            System.out.print("Period in years :");
            years = scanner.nextByte();
            if (years >= 1 && years <=30){
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("enter value between 1 - 30");
        }
        //System.out.print("How many payments made? :");
        //numberOfPaymentsMadeInYears = scanner.nextInt()*MONTHS_IN_YEAR;

        double mortgage = amountOfMoney * ((monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), numberOfPayments))) / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        //double remainingLoan = amountOfMoney*(((Math.pow((1+monthlyInterestRate),numberOfPayments))-(Math.pow(1+monthlyInterestRate,numberOfPaymentsMadeInYears)))/(Math.pow((1+monthlyInterestRate),numberOfPayments)-1));

        for (int i = 0; i <= numberOfPayments; i++){
            double remainingLoan = amountOfMoney*(((Math.pow((1+monthlyInterestRate),numberOfPayments))-(Math.pow(1+monthlyInterestRate,i)))/(Math.pow((1+monthlyInterestRate),numberOfPayments)-1));
            System.out.println(remainingLoan);
        }
        System.out.println("Mortgage :" + mortgage);
        //System.out.println("Number of payments made :"+ numberOfPaymentsMadeInYears + "\nRemaining loan :" + remainingLoan);
        //System.out.println("MonthlyInterestRate :" + monthlyInterestRate);
        //System.out.println("Number Of Payments in total :" + numberOfPayments);

    }
}



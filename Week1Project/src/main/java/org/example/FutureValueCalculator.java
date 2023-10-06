package org.example;
import java.util.Scanner;
public class FutureValueCalculator {
    private final double initialDeposit;
    private final double annualInterestRate;
    private final int numberOfYears;
    private double futureValue;

    public FutureValueCalculator(double initialDeposit,double annualInterestRate, int numberOfYears){
        this.initialDeposit= initialDeposit;
        this.annualInterestRate=annualInterestRate;
        this.numberOfYears=numberOfYears;
    }
    public double getDailyInterestRate(){
        return annualInterestRate/365;
    }
    public double calculateFutureValue(){
        double p = initialDeposit;
        double r = annualInterestRate/100;

        int t = numberOfYears;
        double n = 365;
        double FV = p*(Math.pow((1+(r/n)),(n*t)));
        this.futureValue = FV;
        return futureValue;
    }
    public double calculateTotalInterest(){
        double totalInterest = futureValue - initialDeposit;
        return totalInterest;
    }
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your initial deposit: ");
        double initialDeposit = scanner.nextDouble();
        System.out.println("Enter your annual interest rate: ");
        double annualInterestRate = scanner.nextDouble();
        System.out.println("Enter your number of years: ");
        int numberOfYears = scanner.nextInt();

        FutureValueCalculator calculator = new FutureValueCalculator(initialDeposit,annualInterestRate,numberOfYears);
        double futureValue = calculator.calculateFutureValue();
        double totalInterest = calculator.calculateTotalInterest();
        System.out.printf("If you deposit %.2f in a CD that earns %.2f interest and matures in %d years, your CD's ending balance will be %.2f and you would have earned %.2f in interest",initialDeposit,annualInterestRate,numberOfYears,futureValue,totalInterest);
    }
}

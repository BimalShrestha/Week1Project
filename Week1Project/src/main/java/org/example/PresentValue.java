package org.example;
import java.util.Scanner;
public class PresentValue {
    private double monthlyPayout;
    private double annualInterest;
    private int numberOfYears;
    private double presentAmount;

    public PresentValue(double monthlyPayout, double annualInterest, int numberOfYears){
        this.monthlyPayout = monthlyPayout;
        this.annualInterest = annualInterest;
        this.numberOfYears = numberOfYears;
    }
    public double getMonthlyInterestRate(){
        return annualInterest/1200;
    }
    public double getNumberOfMonthlyPayments(){
        return numberOfYears*12;
    }
    public double calculatePresentValue(){
        double PMT = monthlyPayout;
        double r = getMonthlyInterestRate();
        double n = getNumberOfMonthlyPayments();
        double PV = PMT * ((1-(Math.pow((1+r),-n)))/r);
        this.presentAmount = PV;
        return presentAmount;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the monthly payout: ");
        double monthlyPayout = scanner.nextDouble();
        System.out.println("Enter the expected interest rate: ");
        double interestRate = scanner.nextDouble();
        System.out.println("Enter the number of years to payout: ");
        int numberOfYears = scanner.nextInt();

        PresentValue calculator = new PresentValue(monthlyPayout, interestRate,numberOfYears);
        double presentAmount = calculator.calculatePresentValue();
        System.out.printf("To fund an annuity that pays %.2f monthly for %d years and earns an expected %.2f interest, " +
                "you would need to invest %.2f today",monthlyPayout,numberOfYears,interestRate,presentAmount);
    }
}

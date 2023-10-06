package org.example;
import java.util.Scanner;
public class MortgageCalculator {
    private double principal;
    private double annualRate;
    private int loanYears;
    private double monthlyPayment;
    public MortgageCalculator(double principal, double annualRate, int loanYears){
        this.principal = principal;//parameterized constructor this initiate the current value
        this.annualRate = annualRate;
        this.loanYears = loanYears;

    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the principal: ");
        double principal = scanner.nextDouble();
        System.out.println("Enter the Yearly rate: ");
        double annualRate = scanner.nextDouble();
        System.out.println("Enter the loan years: ");
        int loanYears = scanner.nextInt();
        MortgageCalculator calculator = new MortgageCalculator(principal, annualRate,loanYears );
        double monthlyPayment = calculator.calculateMonthlyPayment();
        double totalInterest = calculator.calculateTotalInterest();
        System.out.printf("Your expected monthly payment is %.2f and you total interest is %.2f",monthlyPayment, totalInterest);

    }


    public double getMonthlyInterestRate(){//it's not static to show the assigned variables
        double r = (annualRate/12)/100;
        return r;
    }
    public int getNumberOfPayments(){
        int n = loanYears*12;
        return n;
    }
    public double calculateMonthlyPayment(){
        double r = getMonthlyInterestRate();
        double p = principal;
        double n = getNumberOfPayments();
        double m = p *( (r*Math.pow((1+r),n))/(Math.pow((1+r),n)-1));
        this.monthlyPayment = m;
        return m;
    }
    public double calculateTotalInterest(){
        double totalInterest = (monthlyPayment*getNumberOfPayments())-principal;
        return totalInterest;
    }

}

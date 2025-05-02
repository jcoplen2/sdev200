import java.util.Date;

public class Loan {
  private double annualInterestRate;
  private int numberOfYears;
  private double loanAmount;
  private Date loanDate;

  // constructor
  public Loan() {
    this(2.5, 1, 1000);
  }

  // constructor with values
  public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
    this.annualInterestRate = annualInterestRate;
    this.numberOfYears = numberOfYears;
    this.loanAmount = loanAmount;
    this.loanDate = new Date();
  }

  // getter and setter methods
  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  public void setAnnualInterestRate(double annualInterestRate) {
    this.annualInterestRate = annualInterestRate;
  }

  public int getNumberOfYears() {
    return numberOfYears;
  }

  public void setNumberOfYears(int numberOfYears) {
    this.numberOfYears = numberOfYears;
  }

  public double getLoanAmount() {
    return loanAmount;
  }

  public void setLoanAmount(double loanAmount) {
    this.loanAmount = loanAmount;
  }

  public Date getLoanDate() {
    return loanDate;
  }

  public double getMonthlyPayment() {
    double monthlyInterestRate = annualInterestRate / 1200;
    return loanAmount * monthlyInterestRate /
        (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
  }

  public double getTotalPayment() {
    return getMonthlyPayment() * numberOfYears * 12;
  }
}

import java.math.BigInteger;
import java.util.Scanner;

public class Rational extends Number implements Comparable<Rational> {
    // Data fields for numerator and denominator
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;
  
    /** Construct a rational with default properties */
    public Rational() {
      this(BigInteger.ZERO, BigInteger.ONE);
    }
  
    /** Construct a rational with specified numerator and denominator */
    public Rational(BigInteger numerator, BigInteger denominator) {
      BigInteger gcd = numerator.gcd(denominator);
      BigInteger sign = denominator.signum() == -1 ? BigInteger.valueOf(-1) : BigInteger.ONE;
      this.numerator = numerator.multiply(sign).divide(gcd);
      this.denominator = denominator.abs().divide(gcd);
    }
  
    /** Return numerator */
    public BigInteger getNumerator() {
      return numerator;
    }
  
    /** Return denominator */
    public BigInteger getDenominator() {
      return denominator;
    }
  
    /** Add a rational number to this rational */
    public Rational add(Rational secondRational) {
      BigInteger n = numerator.multiply(secondRational.getDenominator())
      .add(denominator.multiply(secondRational.getNumerator()));
      BigInteger d = denominator.multiply(secondRational.getDenominator());
      return new Rational(n, d);
    }
  
    /** Subtract a rational number from this rational */
    public Rational subtract(Rational secondRational) {
      BigInteger n = numerator.multiply(secondRational.getDenominator())
      .subtract(denominator.multiply(secondRational.getNumerator()));
      BigInteger d = denominator.multiply(secondRational.getDenominator());
      return new Rational(n, d);
    }
  
    /** Multiply a rational number to this rational */
    public Rational multiply(Rational secondRational) {
      BigInteger n = numerator.multiply(secondRational.getNumerator());
      BigInteger d = denominator.multiply(secondRational.getDenominator());
      return new Rational(n, d);
    }
  
    /** Divide a rational number from this rational */
    public Rational divide(Rational secondRational) {
      BigInteger n = numerator.multiply(secondRational.getDenominator());
      BigInteger d = denominator.multiply(secondRational.getNumerator());
      return new Rational(n, d);
    }
  
    @Override // Override toString()
    public String toString() {
      if (denominator.equals(BigInteger.ONE))
        return numerator + "";
      else
        return numerator + "/" + denominator;
    }
  
    @Override // Override the equals method in the Object class 
    public boolean equals(Object other) {
      if ((this.subtract((Rational)(other))).getNumerator() == 0)
        return true;
      else
        return false;
    }
  
    @Override // Implement the abstract intValue method in Number 
    public int intValue() {
      return (int)doubleValue();
    }
  
    @Override // Implement the abstract floatValue method in Number 
    public float floatValue() {
      return (float)doubleValue();
    }
  
    @Override // Implement the doubleValue method in Number 
    public double doubleValue() {
      return numerator.doubleValue() / denominator.doubleValue();
    }
  
    @Override // Implement the abstract longValue method in Number
    public long longValue() {
      return (long)doubleValue();
    }

    public static void main(String[] args) {
        //get user input
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first rational number with numerator and denominator: ");
        BigInteger n1 = input.nextBigInteger();
        BigInteger d1 = input.nextBigInteger();
        Rational r1 = new Rational(n1, d1);

        System.out.println("Enter second rational number with numerator and denominator: ");
        BigInteger n2 = input.nextBigInteger();
        BigInteger d2 = input.nextBigInteger();
        Rational r2 = new Rational(n2, d2);

        //show requested results
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        System.out.println(r2 + " is " + r2.doubleValue());
    }
  }


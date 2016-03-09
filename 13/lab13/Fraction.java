package lab13;

/**
 * Fraction Interface
 *
 * @author Patrick Murrow
 */

public interface Fraction{

   public Fraction add(Fraction f);

   public Fraction multiply(Fraction f);

   public Fraction divide(Fraction f);

   public Fraction subtract(Fraction f);

   public int getDenom();

   public int getNum();

   public int compareTo(Fraction f);

   public String toString();

   public double getDecimal();

}

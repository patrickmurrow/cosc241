package lab13;

/**
 * A class that takes 2 numbers, a denominator and numerator, or a fraction
 * and performs operations like add and subtract on them
 *
 * @author Patrick Murrow
 */
public class Fraction2 implements Fraction {

   private double dec;
   //private double answer;

   /**
    * Constructor
    */
   public Fraction2(int num, int den){
      dec = (double) num / (double) den;
   }

   /**
    * Constructor
    */
   public Fraction2(double frac){
      dec = frac;
   }

   /**
    * converts fraction to decimal
    *
    *@return decimal version of the fraction
    */
   public double getDecimal(){
      return dec;
   }      
   
   /**
    * adds the current instance fraction to the parameter fraction
    *
    *@return fraction that has been added to another
    *@param fraction
    */
   public Fraction add(Fraction x){
      double answer;
      answer = x.getDecimal() + this.getDecimal();
      return new Fraction2(answer);
   }

   /**
    * subtracts the parameter fraction to the current instance fraction
    *
    *@return subtracted fraction
    *@param fraction
    */
   public Fraction subtract(Fraction x){
      double answer;
      answer = this.getDecimal() - x.getDecimal();
      return new Fraction2(answer);
   }

   /**
    * multiplies the parameter fraction and the current instance fraction
    *
    *@return multiplied fraction
    *@param fraction
    */
   public Fraction multiply(Fraction x){
      double answer;
      answer = x.getDecimal() * this.getDecimal();
      return new Fraction2(answer);
   }

   /**
    * divides the parameter fraction and the current instance fraction
    *
    *@return divided fraction
    *@param fraction
    */
   public Fraction divide(Fraction x){
      double answer;
      answer = this.getDecimal() / x.getDecimal();
      return new Fraction2(answer);
   }

   /**
    * compares two fractions, if fraction 1 > fraction 2 return 1, if 1<2
    * return -1, if equal return 0
    *
    *@return -1, 1 or 0 signifing if < > or =
    *@param fraction
    */
   public int compareTo(Fraction x){
      if (this.getDecimal()<x.getDecimal()){
         return -1;
      }
      else if (this.getDecimal()>x.getDecimal()){
         return 1;
      }
      else{
         return 0;
      }
   }

   /**
    * toString creates something that looks like a fraction eg. 1/2
    *
    *@return string fraction
    */
   public String toString(){
      return ""+this.getNum()+"/"+this.getDenom();
   }

   /**
    * gets the value of the denominator by converting the decimal to numerator
    *
    *@return denominator
    */
   public int getDenom(){
      final double PRECISION = 0.0001;
      double num = 0;
      int denom = 0;
      do {
         denom++;
         num = denom * dec;
      } while (Math.abs(num - Math.round(num)) > PRECISION);
      return denom;
   }

   /**
    * gets the value of the numerator by converting the decimal to numerator
    *
    *@return numerator
    */
   public int getNum(){
      final double PRECISION = 0.0001;
      double num = 0;
      int denom = 0;
      do {
         denom++;
         num = denom * dec;
      } while (Math.abs(num - Math.round(num)) > PRECISION);
      return  (int) Math.round(num);
   }

}
      

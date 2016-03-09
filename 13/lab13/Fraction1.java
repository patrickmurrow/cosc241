package lab13;

/**
 * A class that takes 2 numbers, a denominator and numerator, or a fraction
 * and performs operations like add and subtract on them
 *
 * @author Patrick Murrow
 */
public class Fraction1 implements Fraction {

   private int numer;
   private int denom;

   /**
    * Constructor
    */
   public Fraction1(int num, int den){
      int div = findGCD(num, den);
      numer = num/div;
      denom = den/div;
      if(denom<0) {
         numer*=-1;
         denom*=-1;
      }
   }

   /**
    * gets the value of the numerator
    *
    *@return numerator
    */
   public int getNum(){
      return numer;
   }

   /**
    * gets the value of the denominator
    *
    *@return denominator
    */
   public int getDenom(){
      return denom;
   }

   /**
    * gets the value of the greatest common divisor
    *
    *@return gcd greatest common divisor
    *@param a two ints numerator and denominator
    */
   public int findGCD(int a, int b){
      int temp;
      while (b != 0){
         temp = b;
         b = a%b;
         a = temp;
      }
      return a;
   }

   /**
    * simplifies the fraction by getting the greatest common divisor and
    * dividing by that value
    *
    *@return simplified fraction
    *@param fraction
    */
   public Fraction simplify(Fraction x){
      Fraction answer;
      int gcd = findGCD(x.getNum(), x.getDenom());
      answer = new Fraction1(x.getNum()/gcd, x.getDenom()/gcd);
      return answer;
   }

   /**
    * adds the current instance fraction to the parameter fraction
    *
    *@return fraction that has been added to another
    *@param fraction
    */
   public Fraction add(Fraction x){
      Fraction answer;
      if (this.getDenom() == x.getDenom()){
         answer = new Fraction1(x.getNum() + this.getNum(), x.getDenom());
      }
      else {
         int den = this.getDenom() * x.getDenom();
         int num = this.getNum() * x.getDenom() + x.getNum()
            * this.getDenom();
         answer = new Fraction1(num, den);
      }
      return simplify(answer);
   }

   /**
    * subtracts the parameter fraction to the current instance fraction
    *
    *@return subtracted fraction
    *@param fraction
    */
   public Fraction subtract(Fraction x){
      Fraction answer;
      if (this.getDenom() == x.getDenom()){
         answer = new Fraction1(this.getNum() - x.getNum(), x.getDenom());
      }
      else {
         int den = this.getDenom() * x.getDenom();
         int num = this.getNum() * x.getDenom() - x.getNum()
            * this.getDenom();
         answer = new Fraction1(num, den);
      }
      return simplify(answer);
   }

   /**
    * multiplies the parameter fraction and the current instance fraction
    *
    *@return multiplied fraction
    *@param fraction
    */
   public Fraction multiply(Fraction x){
      Fraction answer;
      int den = this.getDenom() * x.getDenom();
      int num = this.getNum() * x.getNum();
      answer = new Fraction1(num, den);
      return simplify(answer);
   }

   /**
    * divides the parameter fraction and the current instance fraction
    *
    *@return divided fraction
    *@param fraction
    */
   public Fraction divide(Fraction x){
      Fraction answer;
      int den = this.getDenom() * x.getNum();
      int num = this.getNum() * x.getDenom();
      answer = new Fraction1(num, den);
      return simplify(answer);
   }

   /**
    * compares two fractions, if fraction 1 > fraction 2 return 1, if 1<2
    * return -1, if equal return 0
    *
    *@return -1, 1 or 0 signifing if < > or =
    *@param fraction
    */
   public int compareTo(Fraction x){
      double thisFraction = (double)this.getNum()/(double)this.getDenom();
      double xFraction = (double)x.getNum()/(double)x.getDenom();
      if (thisFraction<xFraction){
         return -1;
      }
      else if (thisFraction>xFraction){
         return 1;
      }
      else{
         return 0;
      }
         }

   /**
    * toString creates something that looks like a fraction eg. 1/4
    *
    *@return string fraction
    */
   public String toString(){
      return ""+this.getNum() +"/"+this.getDenom();
   }

   /**
    * converts fraction to decimal
    *
    *@return decimal version of the fraction
    */
   public double getDecimal(){
      return (double) numer / (double) denom;
   }

}


   
      

      
      

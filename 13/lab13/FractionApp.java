package lab13;

import java.util.Scanner;

/**
 *  This is an application class to test the methods of two fraction
 *  implementations.  The only modifications you should need to make are to
 *  the perform() and compare() methods.  You will need to alter the method
 *  calls in those methods to match your Fraction interface. This application
 *  lets you perform some operations with your fraction classes by entering
 *  lines like this:
 *  <pre>
 *  1/2 + 3/4 + -1/3 + 4/6
 *  </pre>
 *  This produces output like this:
 *  <pre>
 *  1/2 + 3/4 = 5/4
 *  5/4 + -1/3 = 11/12
 *  11/12 + 2/3 = 19/12
 *  </pre>
 *  The last operation can be a comparison instead, like this:
 *  <pre>
 *  -2/3 * 6/4 - 4/7 < 1/2
 *  </pre>
 *  This produces output like this:
 *  <pre>
 *  -2/3 * 3/2 = -1/1
 *  -1/1 - 4/7 = -11/7
 *  -11/7 < 1/2 = true
 *  </pre>
 *  Note that all of the fractions get simplified (e.g. 6/4 becomes 3/2)
 *  when they are first created.  This keeps your int/int implementation
 *  consistent with your double implementation.
 *  <p/>
 *  You can change between using a Fraction1 or Fraction2 implementation by
 *  entering 1 or 2 on a line by itself (Fraction1 is the default).
 *
 * @author Iain Hewson
 */
public class FractionApp {

   // Regular expressions to match fractions, operations, or comparisons
   // Don't worry if you don't understand these expressions, but feel free to
   // ask if you want to learn a bit about them

   /**
    *  A fraction will consist of three or four items with no separating
    *  whitespace;  firstly an optional minus sign, then an integer,
    *  then a forward slash, and lastly another integer. 
    */
   public static final String FRACTION = "-?\\d+/\\d+";

   /** An operation is a single character in the set {*, /, +, -}. */
   public static final String OPERATION =
      "[*/+-]"; // the '-' must be the first or last operator in the set
   
   /** A comparison is a single character in the set {<, =, >}. */
   public static final String COMPARISON = "[<=>]";
   
   /**
    *  Contains the main loop which reads one line at a time and either sets
    *  the fraction type or passes the line (wrapped in a scanner) to the
    *  handleLine method along with the fraction type.
    *
    * @param args The command line arguments are not used.
    */
   public static void main(String args[]) {
      // fracType determines whether to create a Fraction1 or Fraction2
      int fracType = 1;
      Scanner input = new Scanner(System.in);
      while (input.hasNextLine()) {
         String line = input.nextLine();
         if (line.equals("1") || line.equals("2")) {
            fracType = Integer.parseInt(line); // change to Fraction 1 or 2
            System.err.println("Using Fraction" + fracType + " implementation");
         } else {
            handleLine(new Scanner(line),fracType);
         }
      }
   }

   /**
    *  Handles a line of input which should contain some fractions separated
    *  by operations (the last operation can be a comparison instead).
    *
    * @param line A scanner containing a single line of input.
    * @param fracType An int (should be either 1 or 2) which specifies whether
    *                 to use a Fraction1 or Fraction2.
    */
   public static void handleLine(Scanner line, int fracType) {
      
      if (line.hasNext(FRACTION)) {  // line must start with a fraction
         Fraction f = makeFraction(new Scanner(line.next()), fracType);

         while (line.hasNext(OPERATION)) {   // can have lots of fraction and
            String operation = line.next();  // operation pairs
         
            if (line.hasNext(FRACTION)) {
               Fraction f2 = makeFraction(new Scanner(line.next()), fracType);
               System.out.print(f + " " + operation + " " + f2 + " = ");
               f = perform(f, operation.charAt(0), f2);
               System.out.println(f);
            } else return; // operation followed by non-fraction is illegal
         }
         
         if (line.hasNext(COMPARISON)) {     // can end with a comparison and
            String comparison = line.next(); // a fraction
            
            if (line.hasNext(FRACTION)) {
               Fraction f2 = makeFraction(new Scanner(line.next()), fracType);
               System.out.print(f + " " + comparison + " " + f2 + " = ");
               System.out.println(compare(f, comparison.charAt(0), f2));
            }
         }
      }
   }

   /**
    *  Makes a new fraction (either Fraction1 or Fraction2 depending on
    *  fracType) using the fraction contained in the scanner fracToken.
    *
    * @param fracToken A scanner which should contain a parsable fraction.
    * @param fracType An int (should be either 1 or 2) which specifies whether
    *                 to create a Fraction1 or a Fraction2.
    * @return A new fraction, or null if fracToken doesn't contain a parsable
    *         fraction.
    */
   public static Fraction makeFraction(Scanner fracToken, int fracType) {
      if (!fracToken.hasNext(FRACTION)) {
         return null;
      }
      fracToken.useDelimiter("/");
      if (fracType == 1) {
         return new Fraction1(fracToken.nextInt(), fracToken.nextInt());
      } else {
         return new Fraction2(fracToken.nextInt(), fracToken.nextInt());
      }
   }
   
   /**
    *  Calculates the result of performing the given operation (which should
    *  be either a +, -, /, or * character) on two fractions.
    *
    * @param first The first fraction to use in the calculation.
    * @param op Determines which operation to perform (defaults to + if an
    *           illegal character is given).
    * @param second The second fraction to use in the calculation.
    * @return A new fraction which is the result of performing the given
    *         opertion on the two fractions.
    */
   public static Fraction perform(Fraction first, char op, Fraction second) {
      //////////////////////////////////////////////////////////////////////
      // You may need to modify the method names to match your interface //
      //////////////////////////////////////////////////////////////////////
      switch (op) {
         case '*':
            return first.multiply(second);
         case '/':
            return first.divide(second);
         case '-':
            return first.subtract(second);
         case '+':
            return first.add(second);
         default:
            throw new IllegalArgumentException("unknown operation '"
                  + op + "'");
      }
   }
   
   /**
    *  Returns the result of comparing two fractions using the given
    *  comparison char (which should be a <, >, or = character).
    *
    * @param first The first fraction to use in the comparison.
    * @param comp Determines the type of comparison to do (defaults to = if an
    *             illegal character is given).
    * @param second The second fraction to use in the comparison.
    * @return the result of comparing two fractions use a given comparison
    *         char.
    */
   public static boolean compare(Fraction first, char comp, Fraction second) {
      ////////////////////////////////////////////////////////////////////////
      // You may need to alter the name compareTo to match your method name //
      ////////////////////////////////////////////////////////////////////////
      switch (comp) {
         case '<':
            return first.compareTo(second) < 0;
         case '>':
            return first.compareTo(second) > 0;
         case '=':
            return first.compareTo(second) == 0;
         default:
            throw new IllegalArgumentException("comparison can't be '"
                  + comp + "'");
      }
   }
   
}

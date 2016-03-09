/* File: CountLines.java - February 2013 */
import java.util.*;

/**
 * This really simple class counts lines of input.
 *
 * @author your name
 */
public class CountLines {
   /**
    * Reads lines of input from the standard input stream (stdin) and
    * prints the total number of lines read to the standard output
    * stream (stdout).
    *
    * @param args Command line arguments are not used.
    */
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int counter = 0;
      while (input.hasNextLine()) {
         counter++;
         input.nextLine(); // read the next line and discard it
      }
      System.out.println(counter);
   }
}



/* File: SecondLargest.java - March 2014 */
package lab06;

import java.util.*;

/**
 * This Class takes integers as input, and returns the second largest number
 * of the numbers
 *
 * @author Patrick Murrow
 */
public class SecondLargest{

   public static Integer [] numArray;

   /**
    * Reads in a scanner and and places the ints into an array, calls
    * firstMethod with that array.
    *
    */
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      Integer[] numArray = getNumbers(input);
      // System.out.println(Arrays.toString(numArray));
      System.out.println(firstMethod(numArray));
      
   }

   /**
    *  Reads some integers from a Scanner (one per line) and returns them in an
    *  array.  Input is read until the first non-integer or EOF is reached.
    *
    * @param input the place where we read our input from.
    * @return an array containing the integers read.
    */ 
   public static Integer[] getNumbers(Scanner input) {
      ArrayList<Integer> numbers = new ArrayList<Integer>();
      String line = "";
      while (input.hasNextInt()) {
         int num = input.nextInt();
         numbers.add(num);
      }
      return numbers.toArray(new Integer[0]);
   }

   /**
    * Compares the numbers in the array and assigns the largest number first
    * if the next number is larger, max is reassigned and the second biggest
    * int max2 is assigned. Then max2 also compares if the next int is
    * smaller than max but greater than max2.
    *
    * @param an array of Integers
    * @return int Second highest number
    */
   public static int firstMethod(Integer[] array){
      int comparisons = 0;
      int max = array[0];
      int max2 = array[1];
      if (max>max2){
         max = max2;
      }
      for (int i = 0; i<array.length; i++){
         if (++comparisons>0 && array[i]> max){
            max2 = max;
            max = array[i];
         }else if (++comparisons>0 && array[i]>max2){
            max2 = array[i];
         }
            }
      System.err.println("Comparisons: "+comparisons);
      return max2 ;
   }
}
   

      

      
      
      
   

/* File: SortAlgorithm.java - March 2014 */
package lab10;

import java.util.*;

/**
 * This Class takes integers as input, and returns the index of where the ints
 * need to be shifted
 *
 * @author Patrick Murrow
 */
public class SortAlgorithm{

   public static Integer [] numArray;

   /**
    * Reads in a scanner and and places the ints into an array, calls
    * search with that array.
    *
    * @param Command prompt arguments
    */
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      Integer[] numArray = getNumbers(input);
      System.out.println(search(numArray, 0, numArray.length-1));
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
    *  Reads some integers from a Scanner (one per line) and returns them in an
    *  array.  Input is read until the first non-integer or EOF is reached.
    *
    * @param the input Array, the desired start and end int to search in
    * @return the index of the smallest int, bordering a larger int
    */
   public static int search(Integer[] array, int left, int right){
      int mid = (left+right)/2;
      if (!(right-left == 1) && !(array[mid] < array[mid-1])){
         if (array[mid] > array[left]){
            return search(array, mid, right);
         }
         else{
            return search(array, left, mid);
         }
      }
      int min = mid;
   if (!(array[mid] < array[mid-1])){
      if (array[0]<array[array.length-1]){
         min = 0;
      }
      else if (array[left]>array[right]){
         min = right;
         }
      else{
         min = left;
      }
   }
      
   return min;
}
}


            
         
      
      
         

      

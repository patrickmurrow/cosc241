/* File: SortAlgorithm.java - March 2014 */
package lab11;

import java.util.*;

/**
 * This Class takes integers as input, and sorts them by jumping in diminishing
 * increments so that a normal insertion sort will perform better
 *
 * @author Patrick Murrow
 */
public class ShellSort extends Sorter{

   //public static Integer [] numArray;
   
   public ShellSort(Integer[] nums){
      super(nums);
   }

   /**
    * Sorts the array using index h which starts high and decreases in value
    * if the number at h is lower than the one beside, swap the values.
    * Then decrease h, and repeat unitl, h equals 1. This will then be an
    * insertion sort but the array will be closer to sorted, an the insertion
    * sort will perform better.
    */ 
   public void sortNums() {
      int tmp;
      h = 1;
      comparisons = 0;
      while(h<nums.length && ++comparisons>0){
         h = 3*h+1;
      }
      while(h>1 && ++comparisons>0){
         h = h/3;
         for(i = h; i<nums.length; i++){
            comparisons++;
            tmp = nums[i];
            j = i - h;
            while(j >= 0 && nums[j]>tmp && ++comparisons>0){
               nums[j+h] = nums[j];
               j = j-h;
            }
            nums[j+h] = tmp;
            update();
         }
      }
      update();
      System.err.println(""+comparisons);
       
   }

   /**
    * Reads in a scanner and and places the ints into an array, calls
    * search with that array.
    *
    * @param Command prompt arguments
    */
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      Integer[] numArray = readNums(input);
      ShellSort list = new ShellSort(numArray);
      list.sortNums();
      for (int pos = 0; pos<list.nums.length; pos++){
         System.out.println(list.nums[pos]);
      }

   }

   /**
    *  Reads some integers from a Scanner (one per line) and returns them in an
    *  array.  Input is read until the first non-integer or EOF is reached.
    *
    * @param input the place where we read our input from.
    * @return an array containing the integers read.
    */ 
   public static Integer[] readNums(Scanner input){
      ArrayList<Integer> numbers = new ArrayList<Integer>();
      String line = "";
      while (input.hasNextInt()) {
         int num = input.nextInt();
         numbers.add(num);
      }
      return numbers.toArray(new Integer[0]);
   }
}
                                    

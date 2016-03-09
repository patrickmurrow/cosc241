/* File: NumberList.java - February 2012 */
package lab04;

/**
 * A basic data structure which is supposed to represent a list of
 * numbers but seems to have a few problems.
 *
 * @author Iain Hewson
 */
public class NumberList {

   /** An array to hold our numbers in. */
   private int[] nums;

   /** How many numbers are currently in our list. */
   private int counter = 0;
   private int maxm;

   /**
    * Creates a new NumberList instance.
    *
    * @param maxsize the maximum number of integers which can be
    *                added to this NumberList.
    */
   public NumberList(int maxsize){
      maxm = maxsize;
      nums = new int[maxm];
   }

   /**
    * Adds the integer number to this NumberList if it contains
    * less than maxsize numbers.
    *
    * @param number an integer to add to this NumberList.
    */
   public void add(int number) {
      if (counter < maxm){ 
      nums[counter] = number;
      counter++;
      }

   }

   /**
    * Restores this NumberList to an empty state.
    */
   public void clear() {
      counter = 0;
   }
   
   /**
    * Return true if this NumberList is empty, otherwise false.
    *
    * @return true if empty, otherwise false.
    */
   public boolean isEmpty() {
      return  counter == 0;
   }

   /**
    * Returns the average of the numbers in this NumberList.
    * Should only be called if the NumberList is not empty.
    *
    * @return the average of the numbers in this NumberList.
    */
   public double calcAverage() {
      double sum = 0;
      for (int i = 0; i < counter; i++) {
         sum += nums[i];
      }
      return sum / (counter);
   }

   /**
    * Returns a string representation of this NumberList.
    *
    * @return a string representation of this NumberList.
    */
   public String toString() {
      StringBuilder result = new StringBuilder("[");
      for (int i = 0; i < counter; i++) { 
         result.append(nums[i]);
         if (i<counter-1){
            result.append(", ");
         }
      }
      result.append(']');
      return result.toString();
   }

}

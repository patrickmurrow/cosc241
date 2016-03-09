/* File: NumberUtils.java  -  February 2013 */
package lab03;

import java.util.*;

/**
 *  This class is used to perform basic operations on an array of integers.
 *
 * @author Iain Hewson
 */
public class NumberUtils {

   /** Array of integers to be used in calculations. */
   private Integer[] nums;
   
   /**
    *  Constructs a new NumberUtils to operate on the given array of integers.
    *
    * @param nums some numbers to operate on.
    */
   public NumberUtils(Integer[] nums) {
      this.nums = nums;
   }

   /**
    *  Return the average of the integers contained in this NumberUtils.
    *
    * @return the average of the integers contained in this NumberUtils.
    */
   public double getAverage() {
      double sum = 0;
      for (int i = 0; i < nums.length; i++) {
         sum += nums[i]; // this is an example of auto-unboxing
      }
      return sum/nums.length;
   }

   /**
    *  Return a string representation of this NumberUtils.
    *
    * @return a string representation of the NumberUtils.
    */
   public String toString() {
      return Arrays.toString(nums);
   }

   /**
    *  Return the maximum of the integers contained in this NumberUtils.
    *
    */
   public int getMax(){
      int max = nums[0];
      for (int i = 0; i <nums.length; i++) {
         if (nums[i]>max){
               max = nums[i];
            }
      }
      return max;
   }

   /**
    *  Return the minimum of the integers contained in this NumberUtils.
    *
    */
   public int getMin(){
      int min = nums[0];
      for (int i = 0; i <nums.length; i++) {
         if (nums[i]<min){
            min = nums[i];
         }
      }
      return min;
   }
   
   
   
}

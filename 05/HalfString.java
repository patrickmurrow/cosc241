/* File: HalfString.java - March 2014 */
package lab05;

import java.util.*;

/**
 * This class takes an input String from the user and halves it. Initially
 * showing the left half and then showing the right half of each split.
 *
 * @author Patrick Murrow
 */

public class HalfString{

   /**
    * Prints out the halves of the String that is read in from the Scanner
    *
    * @param args Command line arguments are not used.
    */

   public static String newString;

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      while (input.hasNextLine()) {
         //half(input.nextLine());
         printHalfIterative(input.nextLine());
      }
   }
   
   /**
    * Recieves input from Scanner (User), takes the midpoint, sets the right
    * half of the string to a new string and prints the left half. The right
    * half is used as a parameter for this same method.
    *
    * @param input from the Scanner
    */
   public static void half(String line) {
      int mid = (line.length()+1)/2;                                        
      if (line.length()>1){
         newString = line.substring(mid,line.length()); 
         String printString = line.substring(0,mid);
         System.out.println(printString);
         half(newString);
      }else{
         System.out.println(newString);
      }
   }

   
   public static void printHalfIterative(String line) {
      //int i =0;
      //while (i<line.length()+1 ){
      while (line.length() > 0){
         int mid = (line.length()+1)/2;
         String printString = line.substring(0, mid);
         System.out.println(printString);
         line = line.substring(mid);
         //i++;
      }
      //System.out.println(line);
   }
      
}


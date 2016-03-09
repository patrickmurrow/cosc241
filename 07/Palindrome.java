/* File: Palindrome.java - March 2014 */
package lab07;

import java.util.*;

/**
 * This Class determines if a string is a Palindrome 
 *
 * @author Patrick Murrow
 */
public class Palindrome{

   private static String newString = "default";
   private static boolean result;
   private static String line = "";

   /**
    * Reads in a scanner and places the string into a variable line, calls
    * isPalindrome with line as the parameter of te normalise method.
    *
    * @param args Command Line Argumets (not used)
    */
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      while(input.hasNextLine()){
         line = input.nextLine();
      
         System.out.println(isPalindrome(normalise(line)));
      }
   }

    /**
     * Takes a string and checks if the first and last letters are equal
     * if yes then the substring without the first and last letters is
     * passed through isPalindrome as parameter sString
     * 
     * @param sString - a sorted string without spaces or special characters
     * @return true or false if palindrome or not
     */
     public static boolean isPalindrome(String sString){
        if (sString.length() <= 1){
           return true;
        }
        else  if (sString.charAt(0)==sString.charAt(sString.length()-1) &&
            sString.length() > 1){
           newString = sString.substring(1, sString.length()-1);
           return isPalindrome(newString);
        }
        return false;
                      
     }
   
   /**
    * If a character is not in the alphabet it is not added to the string that
    * will be returned
    *
    * @param inputLine - input from the scanner
    * @return a sorted string without special characters in lowercase
    */
   public static String normalise(String inputLine){
      String newString = "";
      for (int i = 0; i<inputLine.length(); i++){
         if (Character.isLetter(inputLine.charAt(i))){
            String s = inputLine.charAt(i) + "";
            newString += ""+inputLine.charAt(i);
            }
      
       }
      return newString.toLowerCase();    
   }
}

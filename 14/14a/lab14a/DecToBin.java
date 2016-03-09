package lab14a;

import java.util.*;

/**
 * Converts Decimal numbers to binary using the remainder method and the stack
 *
 */
public class DecToBin{

   public static Stack<Integer> stack = new Stack<Integer>();

   /**
    * Reads in a scanner and and places the ints into an array, calls
    * firstMethod with that array.
    *
    * @param arguments from command line
    */
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      getNumbers(input);
   }
 
   /**
    *  Reads some integers from a Scanner (one per line) and calls convert
    *  on each number.  Input is read until the first non-integer or EOF
    *  is reached.
    *
    * @param input the place where we read our input from.
    */ 
   public static void  getNumbers(Scanner input) {
      String line = "";
      while (input.hasNextInt()) {
         int num = input.nextInt();
         convert(num);
      }
   }

   /**
    * Finds the remainder of the number when divided by 2, then uses the result
    * as the next number. The remainder is added on to the stack and printed
    * when all binary numbers have been found for the decimal
    *
    * @param num - the next number from the input numbers
    */
   public static void convert(int num){
         int x = num;
         System.out.print(num+"=");
         while(x>0){
            stack.push(x%2);
            x = x/2;
         }
         if (!stack.empty()){
            while (!stack.empty()){
               System.out.print(stack.pop());
            }
         }else{
            System.out.print("0");
         }
         System.out.println();
   }
}

   

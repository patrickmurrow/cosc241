/* File: CupEmptierApp.java */
package asgn1;

import java.util.*;

/**
 * This application class tests the methods of the class Cups. And takes input
 * from the user to create instances of Cups to be manipulated
 *
 * @author Patrick Murrow
 * @author Joshua Hii
 */
public class CupEmptierApp{

   /** Data field determining whether to set debugging on or off*/   
   private static int debug = 0;
   
   /**
    * Creates a Cups and calls handleLine() with each line of input to
    * manipulate the list of stones.
    *
    * @param args command line arguments are not used.
    */
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      Cups numArray = new Cups(getNumbers(input));
      while (input.hasNextLine()) {
         handleLine(input.nextLine(), numArray);
      }
   }

   public static List<Integer> getNumbers(Scanner input) {
      List<Integer> numbers = new ArrayList<Integer>();
      while (input.hasNextInt()) {
         int num = input.nextInt();
         numbers.add(num);
      }
      return numbers;
   }

   /**
    * Uses the contents of scanline to manipulate the list.  Possible options
    * are: <br/>
    * C item (clear and add an items to the of the list) <br/>
    * E index (empties the cup at the given index into all other indexes ) <br/>
    * F (sees if all cups can be emptied into a single cup within limit) <br/>
    * P (print out the current list of stones)
    * D (turns debugging on and off)
    *
    * @param scanline a scanner which should contain either 'c', 'e', 'f', 'p'
    *                 or 'd' followed by an item.
    * @param stones, a list of stones to manipulate.
    */
   public static void handleLine(String line, Cups stones) {
      Scanner tokens = new Scanner(line);
      if (tokens.hasNext("[pcefd]")) {
         // if next token is p, c, e, f, or d
         char command = tokens.next().charAt(0);
         switch (command) {
         case 'p':
            System.out.println(stones.toString());
            break;
         case 'c':
            stones.clear();
            while(tokens.hasNextInt()){
               stones.add(tokens.nextInt());
            }
            break;
         case 'e':
            if (tokens.hasNext()) {
               stones.empty(tokens.nextInt());
            }
            break;
         case 'f':
            if(tokens.hasNextInt()){
               int limit = tokens.nextInt();
               stones.solve(stones, limit, debug);
            }else{
               int limit = stones.size(stones);
               stones.solve(stones, limit, debug);
            }
            break;
         case 'd':
            if (debug == 0){
               debug = 1;
            }else{
               debug = 0;
            }
            break;
         }
      }
   }
}

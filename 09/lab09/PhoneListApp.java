/* File: PhoneListApp.java - March 2014 */
package lab09;

import java.util.Scanner;

/**
 * This Class takes a name and number as input from the user and adds it to
 * a HashMap "phonebook"
 *
 * @author Patrick Murrow
 */
public class PhoneListApp{


   /**
    * Reads in a scanner and places the string into a variable input, calls
    * handleLine with input.nextLine() and the instance of PhoneList as
    * parameters as the parameter of te normalise method.
    *
    * @param args Command Line Arguments (not used)
    */
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      PhoneList nInput = new PhoneList();
      while (input.hasNextLine()) {
         handleLine(input.nextLine(), nInput);
      }
   }

   
   /**
    * Takes a, g, r or p as intput and either adds name and number, gets the
    * number of the name given, removes the name and number of the name given
    * or prints the list
    *
    * @param line - Line of input form scanner. nInput - instance of PhoneList
    */
   public static void handleLine(String line, PhoneList nInput) {
      String name = "";
      String num = "";
      Scanner tokens = new Scanner(line);
      if (tokens.hasNext("[agrp]")) {
         // if next token is a, g, r, or p
         char command = tokens.next().charAt(0);
         switch (command) {
         case 'a':
            while (tokens.hasNext()){
               if (tokens.hasNext()) {
                  name = tokens.next();
               }
               if (tokens.hasNext()){
                  num = tokens.next();
                  nInput.addEntry(name, num);
               }
            }
            break;
         case 'g':
            String nameC = tokens.next();
            if(nInput.contains(nameC)){
               System.out.println(nInput.getNumber(nameC));
            }
            break;
         case 'r':
            String nameR = tokens.next();
            if(nInput.contains(nameR)){
               nInput.remove(nameR);
            }
            break;
         case 'p':
            System.out.println(nInput.toString());
         }
      }
   }
}

      


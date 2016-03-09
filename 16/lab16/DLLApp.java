package lab16;

import java.util.Scanner;

public class DLLApp {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      DLL<Integer> thing = new DLL<Integer>();
      while (input.hasNextLine()) {
         handleLine(new Scanner(input.nextLine()), thing);
      }
   }
   public static void handleLine(Scanner tokens, DLL<Integer> thing) {
      if (tokens.hasNext("[aesdgpr]")) {
         char command = tokens.next().charAt(0);
         switch (command) {
         case 'a':
            if (tokens.hasNextInt()) {
               int elem = tokens.nextInt();
               if(tokens.hasNextInt()){
                  thing.addAfter(elem, tokens.nextInt());
               }
            }
            break;
         case 'e':
            while (tokens.hasNextInt()) {
               thing.addLast(tokens.nextInt());
            }
            break;
         case 's':
            while (tokens.hasNextInt()) {
               thing.addFirst(tokens.nextInt());
            }
            break;
         case 'd':
            while (tokens.hasNextInt()) {
               thing.delete(tokens.nextInt());
            }
            break;
         case 'g':
            System.out.println(thing.partition());
            break;
         case 'p':
            System.out.println(thing.toString());
            break;
         case 'r':
            System.out.println("reverse: " + thing.reverseString());
            break;
         }
      }
   }
}

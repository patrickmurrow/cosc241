package lab19;

import java.util.Scanner;
public class BSTApp {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      BST<String> thing = new BST<String>();
      while (input.hasNextLine()) {
         handleLine(input.nextLine(), thing);
      }
   }
   public static void handleLine(String line, BST<String> thing) {
      Scanner tokens = new Scanner(line);
      if (tokens.hasNext("[idp]")) {
         // if next token is a, r, or p
         char command = tokens.next().charAt(0);
         switch (command) {
         case 'i':
            while (tokens.hasNext()) {
               thing.insert(tokens.next());
            }
            break;
         case 'd':
            while (tokens.hasNext()) {
               thing.delete(tokens.next());
            }
            break;
         case 'p':
            System.out.println(thing.toString());
            System.out.println(thing.toPrettyString());
            break;
         }
      }
   }
}

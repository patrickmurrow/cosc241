package lab19;

import java.util.*;

public class BSTApp{

   public static void main(String args[]) {
      BST<String> queue = new BST<String>();
      Scanner input = new Scanner(System.in);
      while (input.hasNextLine()) {
         handleLine(new Scanner(input.nextLine()), queue);
      }
   }

   public static void handleLine(Scanner scanline, BST<String> queue) {
      if (scanline.hasNext("[idp]")) {
         char command = scanline.next().charAt(0);
         switch (command) {
         case 'i':
            while (scanline.hasNext()){
               queue.insert(scanline.next());
            }
            break;
         case 'd':
            queue.delete(scanline.next());
            break;
         case 'p':
            System.out.println(queue.toString());
            System.out.println(queue.toPrettyString());
            break;
         }
      }
   }

}

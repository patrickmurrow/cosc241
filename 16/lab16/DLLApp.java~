package lab16;

import java.util.*;

/**
 *
 *
 * @author Patrick Murrow
 */
public class DLLApp{

   /**
    * 
    *
    * @param args command line arguments are not used.
    */
   public static void main(String args[]) {
      DLL<Integer> queue = new DLL<Integer>();
      Scanner input = new Scanner(System.in);
      while (input.hasNextLine()) {
         handleLine(new Scanner(input.nextLine()), queue);
      }
   }

   /**
    * Uses the contents of scanline to manipulate the queue.  Possible options
    * are: <br/>
    * A item (add an item to the end of the queue) <br/>
    * E (insert an element at the end of the list) <br/>
    * S (insert an element at the start of the list) <br/>
    * D (delete the given element from the list if it's there) <br/>
    * P (print out the entire queue)
    * R (remove and print the item at the front of the queue) <br/>
    * @param scanline a scanner which should contain either 'a','e','s','d','p'
    *                 or 'r' followed by an item.
    * @param queue a queue to manipulate.
    */
   public static void handleLine(Scanner scanline, DLL<Integer> queue) {
      if (scanline.hasNext("[aesdgpr]")) {
         char command = scanline.next().charAt(0);
         switch (command) {
         case 'a':
            if (scanline.hasNextInt()){
               int elem = scanline.nextInt();
               if (scanline.hasNextInt()){
                  int prev = scanline.nextInt();
                  queue.addAfter(elem,prev);
               }
            }
            break;
         case 'e':
            while (scanline.hasNextInt()){
               queue.addLast(scanline.nextInt());
            }
            break;
         case 's':
            while (scanline.hasNextInt()){
               queue.addFirst(scanline.nextInt());
            }
            break;
         case 'd':
            while (scanline.hasNextInt()){
               queue.delete(scanline.nextInt());
            }
            break;
         case 'g':
            System.out.println(queue.partition());
            break;
         case 'p':
            System.out.println(queue.toString());
            break;
         case 'r':
            System.out.println("reverse: " + queue.reverseString());
            break;
         }
      }
   }

}

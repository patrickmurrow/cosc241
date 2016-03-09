/* File: QueueApp.java */
package lab14b;

import java.util.*;

/**
 * This is an application class to test the methods of the class TwoStackQueue.
 * You will need to write this file as well as your TwoStackQueue during the
 * prac test (but you won't need to comment it during the test).
 *
 * @author Iain Hewson
 */
public class QueueApp {

   /**
    * Creates a TwoStackQueue and calls handleLine() with each line of input to
    * manipulate the queue.
    *
    * @param args command line arguments are not used.
    */
   public static void main(String args[]) {
      Queue<String> queue = new TwoStackQueue<String>();
      Scanner input = new Scanner(System.in);
      while (input.hasNextLine()) {
         handleLine(new Scanner(input.nextLine()), queue);
      }
   }

   /**
    * Uses the contents of scanline to manipulate the queue.  Possible options
    * are: <br/>
    * A item (add an item to the end of the queue) <br/>
    * R (remove and print the item at the front of the queue) <br/>
    * G (get and print the item at the front of the queue) <br/>
    * P (print out the entire queue)
    *
    * @param scanline a scanner which should contain either 'r', 'g', 'p' or
    *                 'a' followed by an item.
    * @param queue a queue to manipulate.
    */
   public static void handleLine(Scanner scanline, Queue<String> queue) {
      if (scanline.hasNext("[argp]")) {
         char command = scanline.next().charAt(0);
         switch (command) {
            case 'a':
               while (scanline.hasNext()) {
                  queue.addLast(scanline.next());
               }
               break;
            case 'r':
               if (!queue.isEmpty()) {
                  System.out.println(queue.removeFirst());
               }
               break;
            case 'g':
               if (!queue.isEmpty()) {
                  System.out.println(queue.getFirst());
               }
               break;
            case 'p':
               System.out.println(queue);
               break;
         }
      }
   }

}

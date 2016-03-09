package lab21;

import java.util.*;

public class DLLApp{

   public static void main(String args[]) {
      DLL<Integer> queue = new DLL<Integer>();
      Scanner input = new Scanner(System.in);
      while (input.hasNextLine()) {
         handleLine(new Scanner(input.nextLine()), queue);
      }
   }

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

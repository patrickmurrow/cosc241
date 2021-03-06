package lab15;

import java.util.*;

public class DLLApp{

   public static void main(String args[]) {
      DLL<String> list = new DLL<String>();
      Scanner input = new Scanner(System.in);
      while (input.hasNextLine()) {
         handleLine(new Scanner(input.nextLine()), list);
      }
   }

   public static void handleLine(Scanner scanline, DLL<String> list) {
      if (scanline.hasNext("[aesdpr]")) {
         char command = scanline.next().charAt(0);
         switch (command) {
         case 'a':
            while (scanline.hasNext()) {
               list.addAfter(scanline.next(),scanline.next());
            }
            break;
         case 'e':
            while (scanline.hasNext()) {
               list.addFirst(scanline.next());
            }
            break;
         case 's':
            while (scanline.hasNext()) {
               list.addLast(scanline.next());
            }
            break;
         case 'd':
            list.delete(scanline.next());
            break;
         case 'p':
            System.out.println(list.toString());
            break;
         case 'r':
            // System.out.println(list.reverseString());
            break;
         }
      }
   }

}

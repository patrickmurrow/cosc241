package lab18;

import java.util.*;

public class ImmutableListApp{

   public static void main(String args[]) {
      ImmutableList<String> list = new ImmutableList<String>();
      Scanner input = new Scanner(System.in);
      while (input.hasNextLine()) {
        list =  handleLine(new Scanner(input.nextLine()), list);
      }
   }

   public static ImmutableList<String> handleLine(Scanner scanline, ImmutableList<String> list) {
      if (scanline.hasNext("[arsp]")) {
         char command = scanline.next().charAt(0);
         switch (command) {
         case 'a':
            while (scanline.hasNext()){
               list = list.add(scanline.next());
            }
            break;
         case 'r':
            String input = scanline.next();
            if (list.contains(input)){
               int i = list.indexOf(input);
               list = list.remove(i);
            }
            break;
         case 's':
            list = list.set(scanline.nextInt(), scanline.next());
            break;
         case 'p':
            System.out.println(list);
            break;
         }
      }
      return list;
   }

}

import java.util.*;

public class SayHello{


   public static void main(String[] args) {
      if (args.length < 1) {
         System.err.println("Error: no arguments given");
      } else {
         try {
            int count = Integer.parseInt(args[0]);
            sayHello(count);
         } catch (NumberFormatException e) {
            System.err.println(e);
         }
      }
   }

   public static void sayHello(int count) {
      if (count > 0) {
         System.out.println("Hello");
         sayHello(count-1);
      }
   }

}

package lab18;
import java.util.Scanner;
public class ImmutableListApp {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      ImmutableList<String> thing = new  ImmutableList<String>();
      while (input.hasNextLine()) {
         thing = handleLine(input.nextLine(), thing);
      }
   }
   public static  ImmutableList<String> handleLine(String line, ImmutableList<String> thing) {
      Scanner tokens = new Scanner(line);
      if (tokens.hasNext("[arsp]")) {
         // if next token is a, r, or p
         char command = tokens.next().charAt(0);
         switch (command) {
         case 'a':
            while (tokens.hasNext()) {
               thing = thing.add(tokens.next());
            }
            break;
         case 'r':
            String temp = tokens.next();
            if (thing.contains(temp)){
               int i = thing.indexOf(temp);
               thing = thing.remove(i);
            }
            break;
         case 's':
            thing = thing.set(tokens.nextInt(), tokens.next());
            break;
         case 'p':
            System.out.println(thing);
            break;
         }
      }
      return thing;
   }
}

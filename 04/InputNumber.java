package lab04;

import java.util.Scanner;

public class InputNumber {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      NumberList nInput = new NumberList(10);
      while (input.hasNextLine()) {
         handleLine(input.nextLine(), nInput);
      }
   }

   public static void handleLine(String line, NumberList nInput) {
      Scanner tokens = new Scanner(line);
      if (tokens.hasNext("[acrp]")) {
         // if next token is a, c, r, or p
         char command = tokens.next().charAt(0);
         switch (command) {
         case 'a':
            while (tokens.hasNextInt()) {
               int num = tokens.nextInt();
               nInput.add(num);
            }
            break;
         case 'c':
            if (!nInput.isEmpty()){
            System.out.println( nInput.calcAverage());
            }
            break;
         case 'r':
            nInput.clear();
            break;
         case 'p':
            System.out.println(nInput.toString());
            break;
         }
      }
   }
}

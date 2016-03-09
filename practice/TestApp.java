package lab08practice;

import java.util.Scanner;

public class TestApp{

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      NumberList nInput = new NumberList(10);
      while (input.hasNextInt()) {
         int num = input.nextInt();
         nInput.add(num);
         }
      if (!nInput.isEmpty()){
         System.out.println(nInput.toString());
         System.out.printf("The average is %.1f\n", nInput.calcAverage());
      }
   }
}

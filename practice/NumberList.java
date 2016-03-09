package lab08practice;

public class NumberList {

   private int[] nums;
   private int counter = 0;
   private int maxm;

   public NumberList(int maxsize){
      maxm = maxsize;
      nums = new int[maxm];
   }

   public void add(int number) {
      if (counter < maxm){ 
         nums[counter] = number;
         counter++;
      }
   }

   public boolean isEmpty() {
      return  counter == 0;
   }

   public double calcAverage() {
      double sum = 0;
      for (int i = 0; i < counter; i++) {
         sum += nums[i];
      }
      return sum / (counter);
   }

   public String toString() {
      StringBuilder result = new StringBuilder("[");
      for (int i = 0; i < counter; i++) { 
         result.append(nums[i]);
         if (i<counter-1){
            result.append(", ");
         }
      }
      result.append(']');
      return result.toString();
   }
}

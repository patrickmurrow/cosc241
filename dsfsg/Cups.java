package asgn1;

import java.util.*;

public class Cups{

   private List<Integer> stoneList;
   private List<Integer> sList;
   private ArrayList<Integer> moves = new ArrayList<Integer>();
   // private ArrayList<ArrayList> resultArray = new ArrayList<ArrayList>();
      
   public Cups(List<Integer> stones){
      this.stoneList = stones;
      this.sList = stones;
        
   }

   public Cups empty(int index){
      Cups answer;
      sList = new ArrayList<Integer>(stoneList);
      if (index<sList.size()){
         int num = sList.get(index);
         sList.set(index, 0);
         int i = index+1;
         while (num>0){
            if (i >= sList.size()){
               i = 0;
            }
            sList.set(i, sList.get(i)+1);
            i++;
            num -= 1;
         }
         if (sList.get(index) == 0){
            sList.remove(index);
         }
      }
      return answer = new Cups(sList);
   }

   public void solve(Cups parent, int limit, int debug){
      for (int x = 0; x<size(parent); x++){
         Cups child = parent.empty(x);
         moves.add(x);
         if (debug == 1){
            System.out.println(parent);
         }
         if (size(child) == 1){
            System.out.print("moves:" + moves);
            Cups next = new Cups(getList(this.empty(moves.get(0))));
            System.out.print(" cups:" + next);
            for(int i = 0; i<moves.size(); i++){
               System.out.print(" " + next.empty(moves.get(i)));
               next = next.empty(moves.get(i));
            }
            System.out.println();
         }
         if (limit>1 && size(child)>1){
            solve(child, limit-1, debug);
         }         
         moves.remove(moves.size()-1);
         if (x==size(child)-1){
            limit++;
         }
      }
   }



   public String toString(){
      StringBuilder result = new StringBuilder("(");
      for (int i = 0; i<this.sList.size(); i++){
         result.append(this.sList.get(i));
         if (i<this.sList.size()-1){
            result.append(", ");
         }
      }
      result.append(")");
      return result.toString();
   }
	

   //  public void getAnswer(Cups list){
   // System.out.println("m: " + list.moves);
      // System.out.println("r: " + list.resultArray);
   //  }

   public void clear(){
      stoneList.clear();
   }

   public void add(int i){
      stoneList.add(i);
   }

   public List<Integer> getList(Cups list){
      return stoneList;
   }

   public int size(Cups list){
      return list.stoneList.size();
   }
}

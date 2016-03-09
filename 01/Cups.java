package asgn1;

import java.util.*;

public class Cups{

   private List<Integer> stoneList;
   private List<Integer> sList;
   private ArrayList<Integer> moves = new ArrayList<Integer>();
   private int answer;
   private int limitD;
      
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
      limitD = limit;
      for (int x = 0; x<getSize(parent); x++){
         Cups child = parent.empty(x);
         if (debug == 1){
            Cups temp = new Cups(stoneList);
            for (int i = 0; i<moves.size(); i++){
               temp = temp.empty(moves.get(i));
            }
               System.err.println(temp + " empty-cup:" + x + ", limit:" + 
                                  limit + " => " + child);
         }
         moves.add(x);
         if (getSize(child) == 1){
            this.answer = 1;
            System.out.print("moves:" + moves);
            Cups p = new Cups(getList(this.empty(moves.get(0))));
            System.out.print(" cups:" + p);
            for(int i = 0; i<moves.size(); i++){
               System.out.print(" " + p.empty(moves.get(i)));
               p = p.empty(moves.get(i));
            }
            System.out.println();
         }
         if (limit>1 && getSize(child)>1){
            solve(child, limit-1, debug);
         }
         moves.remove(moves.size()-1);
         if (x==getSize(parent)-1){
            limit++;
         }
      }
   }

   public String error(){
      String ans = "";
      if (getAnswer()){
          ans = stoneList + " cannot be solved in " +limitD + " moves.";
      }
      return ans;
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
	
   public void clear(){
      stoneList.clear();
   }

   public void add(int i){
      stoneList.add(i);
   }

   public List<Integer> getList(Cups list){
      return stoneList;
   }

   public int getSize(Cups list){
      return list.stoneList.size();
   }

   public boolean getAnswer(){
      return this.answer == 0;
   }
}

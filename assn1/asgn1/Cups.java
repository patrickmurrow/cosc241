/* File: Cups.java */
package asgn1;

import java.util.*;

/**
 * The Cups class simulates a set of cups being individually emptied into 
 * one another. It shows what sequence of moves need to be taken to successfully
 * empty the stones into one cup.
 * 
 * @author Patrick Murrow
 * @author Joshua Hii
 *
 */
public class Cups{
    
   /** Lists representing the amount of stones in each cup */
   private List<Integer> stoneList;
   private List<Integer> sList;

   /** An ArrayList representing each successive cup being emptied */
   private ArrayList<Integer> moves = new ArrayList<Integer>();
    
   /** 
    * Constructor that sets stoneList and sList to the given List of stones
    *
    * @param stones, a List of numbers indicating the amount of stones in each
    * cup
    */  
   public Cups(List<Integer> stones){
      this.stoneList = stones;
      this.sList = stoneList; //copy of stoneList which can be manipulated
   }

   /** 
    * Empties the "Cup" or number at the given index in a clockwise rotation.
    * 1 is added in a clockwise rotation as 1 is taken away from the original 
    * number/cup. The cup is removed if it is empty after the rotation.
    *
    * @param index, given integer indicating the index of which cup to empty
    * @return answer a new instance of cups filled with the result of the empty
    *
    */
   public Cups empty(int index){
      Cups answer;
      sList = new ArrayList<Integer>(stoneList);
      if (index<sList.size()){ // if index is valid
         int num = sList.get(index); //get the value at the index
         sList.set(index, 0); //set the value at the index to zero
         int i = index+1; // start at the next cup
         while (num>0){
            if (i >= sList.size()){
               i = 0; // if index is the last cup, go back to the first cup
            }
            sList.set(i, sList.get(i)+1); // add 1 to the cup
            i++;
            num -= 1; // take 1 away from the stones in the original cup
         }
         if (sList.get(index) == 0){
            sList.remove(index); // remove the cup(indexed element) if empty
         }
      }
      return answer = new Cups(sList);
   }

   /**
    * Finds the successive moves needed to empty all stones into a single cup
    * and prints the result with the steps of change in the cups.
    *
    * @param parent, instnace of Cups that will be updated 
    * @param limit integer that sets the amount of steps can be taken to reach 
    * a single cup
    * @param debug, integer that is either 1 for debugging on or 0 for off
    *
    */
   public void solve(Cups parent, int limit, int debug){
      for (int x = 0; x<size(parent); x++){
         Cups child = parent.empty(x); // the next set of cups/branch
         if (debug == 1){ // if debugging is enabled
            Cups temp = new Cups(stoneList); // create a temp Cups
            for (int i = 0; i<moves.size(); i++){
               temp = temp.empty(moves.get(i)); //parent of current child
            }
            System.err.println(temp + " empty-cup:" + x + ", limit:" + 
                               limit + " => " + child);
         }
         moves.add(x); // add the index used to empty to a List; moves
         if (size(child) == 1){ // if valid answer: use moves to print steps
            System.out.print("moves:" + moves);
            // currCup is a copy of the original list
            Cups currCup = new Cups(stoneList);
            System.out.print(" cups:" + currCup);
            for(int i = 0; i<moves.size(); i++){
               System.out.print(" " + currCup.empty(moves.get(i)));
               currCup = currCup.empty(moves.get(i)); //use currCup as parent
            }
            System.out.println();
         }
         if (limit>1 && size(child)>1){ // limit hasn't been reached 
            solve(child, limit-1, debug); // continue down tree, empty again
         }
         moves.remove(moves.size()-1); // if fails, remove previous move
         if (x==size(parent)-1){
            limit++; //if fail, go back a step and try from next index
         }
      }
   }


   /** 
    * Takes a list and and it's elements and puts them around curved braces
    *
    * @return result, a string version of the List in curved braces
    */
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
    
   /** 
    * Removes all elements of the list
    */    
   public void clear(){
      stoneList.clear();
      sList.clear();
   }

   /** 
    * Adds an element to the list
    * 
    * @param stone, integer which indicates amount of stones to add to a cup
    */ 
   public void add(int stone){
      this.stoneList.add(stone);
      sList = stoneList;
   }

   /** 
    * Returns the List of stones in an instance of Cups
    *
    * @param list, instance of cups
    * @return stoneList, the list of stones in the Cups instance
    */ 
   public List<Integer> getList(Cups list){
      return stoneList;
   }

   /** 
    * Returns the size of the list in the Cups instance
    *
    * @param list, instance of Cups
    * @return stoneList length
    */ 
   public int size(Cups list){
      return list.stoneList.size();
   }
}

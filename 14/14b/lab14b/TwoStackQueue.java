package lab14b;

import java.util.*;

/**
 * Add elements a to a queue made from two stacks and determine which element
 * was the first added, which element is at the front of the queue and prints
 * out the state of the two queues
 *
 */
public class TwoStackQueue<E> implements Queue<E>{

   public Stack<E> left = new Stack<E>();
   public Stack<E> right = new Stack<E>();
   
   /**
    * Return true if and only if this Queue is empty.
    *
    * @return true if this Queue is empty, otherwise false.
    */
   public boolean isEmpty(){
      return left.empty() && right.empty();
   }

   
   /**
    * Return the length of this Queue.
    *
    * @return the number of elements in this Queue.
    */
   public int size(){
      return left.size() + right.size();
   }

   /**
    * Return the element at the front of this Queue.
    *
    * @return the element at the front of this Queue.
    * @throws EmptyQueueException if this Queue is empty.
    */
   public E getFirst(){
      if (isEmpty()){
         throw new EmptyQueueException();
      }
      else if(!(right.empty())){
         return right.peek();
      }
      else{
         while(!left.empty()){
            right.push(left.pop());
         }
         return right.peek();
      }
   }
   
   /**
    * Make this Queue empty.
    */
   public void clear(){
      while(!right.empty()){
         right.pop();
      }
      while(!left.empty()){
         left.pop();
      }
   }
   
   /**
    * Add an element to the rear of this Queue.
    *
    * @param elem the Object to be added to the rear of the Queue.
    */
   public void addLast(E elem){
      left.push(elem);
   }
   
   /**
    * Remove and return the front element of this Queue.
    *
    * @return the element at the front of this Queue.
    * @throws EmptyQueueException if this Queue is empty.
    */
   public E removeFirst() throws EmptyQueueException{
      if (isEmpty()){
         throw new EmptyQueueException();
      }
      else if(!(right.empty())){
         return right.pop();
      }
      else{
         while(!(left.empty())){
            right.push(left.pop());
         }
         return right.pop();
      }

   }

   /**
    * Returns the default toString for a stack for right and left
    *
    */
   public String toString() {
      return left.toString() + right.toString();
   }
   
}


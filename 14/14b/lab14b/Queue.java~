/* File: Queue.java */
package lab14b;

/**
 * A first-in-first-out collection of objects.
 *
 * @author Iain Hewson
 */
public interface Queue<E> {
   
   /**
    * Return true if and only if this Queue is empty.
    *
    * @return true if this Queue is empty, otherwise false.
    */
   public boolean isEmpty();
   
   /**
    * Return the length of this Queue.
    *
    * @return the number of elements in this Queue.
    */
   public int size();

   /**
    * Return the element at the front of this Queue.
    *
    * @return the element at the front of this Queue.
    * @throws EmptyQueueException if this Queue is empty.
    */
   public E getFirst();
   
   /**
    * Make this Queue empty.
    */
   public void clear();
   
   /**
    * Add an element to the rear of this Queue.
    *
    * @param elem the Object to be added to the rear of the Queue.
    */
   public void addLast(E elem);
   
   /**
    * Remove and return the front element of this Queue.
    *
    * @return the element at the front of this Queue.
    * @throws EmptyQueueException if this Queue is empty.
    */
   public E removeFirst();
   
}

package lab15;

/**
 * This class implements doubly linked lists, as covered in Cosc241 lectures.
 *
 * @author  Iain Hewson
 */
public class DLL<E> {

   /** A reference to the first node in this DLL. */
   private Node<E> first;

   /** A reference to the last node in this DLL. */
   private Node<E> last;

   /**
    * Construct an empty DLL.
    */
   public DLL() {
      first = null;
      last = null;
   }
   
   /**
    * Return the first element in this DLL, or null if DLL empty.
    *
    * @return  The first element in this DLL, or null if DLL empty.
    */
   public E getFirst() {
      return first != null ? first.element : null;
   }
   
   /**
    * Return the last element in this DLL, or null if DLL empty.
    *
    * @return  The last element in this DLL, or null if DLL empty.
    */
   public E getLast() {
      return last != null ? last.element : null;
   }

   /**
    * Return the number of nodes in this DLL.
    *
    * @return  The number of nodes in this DLL.
    */
   public int size() {
      // implement this method
      int counter = 1;
      if (first == null){
         counter =0;
      }else{
         for (Node<E> node = first; node != last; node = node.next){
            counter++;
         }
      }
      return counter;
   }

   /**
    * Add an element to the start of this DLL.
    *
    * @param elem  An element to add to the start of this DLL.
    */
   public void addFirst(E elem) {
      insert(elem, null);
   }
   
   /**
    * Add an element to the end of this DLL.
    *
    * @param elem  An element to add to the end of this DLL.
    */
   public void addLast(E elem) {
      // implement this method (only takes one line of code)
      insert(elem, last);
   }

   /**
    * Add a new element after the element 'prev' (or at the end of this DLL if
    * 'prev' isn't found).
    *
    * @param elem  A new element to add to this DLL.
    * @param prev  An element to add 'elem' after.
    */
   public void addAfter(E elem, E prev) {
      // implement this method (start by searching for prev)
      if (search(prev) == null){
         insert(elem, last);
      }else{
         insert(elem, search(prev));
      }
   }

   
   /**
    * Delete a given element from this DLL.
    *
    * @param elem  An element to delete from this DLL.
    */
   public void delete(E elem) {
      // implement this method
      Node<E> node = search(elem);
      if (node != null){
         if (node == first) {  // if there is nothing in front of the newNode but *
            first = node.next;
            if (first != null){
               first.prev = null;
            }else{
               last = null;
            }
         }else if(node == last) {  // if newNode is the last
            last = node.prev;
            last.next = null;
            
         }else { // if newNode is in the middle
            node.prev.next = node.next;
            node.next.prev = node.prev; 
         }
      }
   }


   /**
    * Return a string representation of DLL to allow System.out.println(aList).
    *
    * @return  A String representation of this DLL.
    */
   public String toString() {
      String result = "[";
      for (Node<E> curr = first; curr != null; curr = curr.next) {
         result += curr;
         if (curr != last) {
            result += ", ";
         }
      }
      return result + "]";
   }
 
   /**
    * Return a string representation of all the elements in this DLL, in 
    * last-to-first order.
    *
    * @return  A String representation of this DLL in reverse order.
    */
   public String reverseString() {
      // implement this method (very similar to the toString method)
      String result = "[";
      for (Node<E> curr = last; curr != null; curr = curr.prev) {
         result += curr;
         if (curr != first) {
            result += ", ";
         }
      }
      return result + "]";
   }
   
   /**
    * Find the first Node which contains the given element.
    *
    * @param elem  The element to search for.
    * @return The first Node containing the given element, or null if no Node
    *         contains the element.
    */
   private Node<E> search(E elem) {
      // implement this method (use a for loop like in the toString)
      for (Node<E> curr = first; curr != null; curr = curr.next) {
         if (elem.equals(curr.element)) {
            return curr;
         }
      }
      return null;
   }

   /**
    * Insert a new element after the element 'prev'.  If 'prev' is null then
    * insert 'elem' at the front of this DLL.
    *
    * @param elem  A new element to insert into this DLL.
    * @param prev  An element to insert 'elem' after. If 'prev' is null insert
    * 'elem' at the start of this DLL.
    */
   private void insert(E elem, Node<E> prev) {
      // implement this method
      Node<E> newNode = new Node<E>(elem, null, null);
      if (prev == null) {  // if there is nothing in front of the newNode but *
         newNode.next = first;
         if (first == null){ // if there is nothing at all
            last = newNode;
         }else { // * things at the back
            first.prev = newNode;
         }
         first = newNode; // setting the new first as newNode
      }else if(prev == last) {  // if newNode is the last
         last.next = newNode;
         newNode.prev = last;
         last = newNode; // setting the new last as newNode
      }else { // if newNode is in the middle
         newNode.next = prev.next;
         prev.next.prev = newNode;
         prev.next = newNode;
         newNode.prev = prev;  
      }
   }
      /**
       * A simple container class which holds an element, and references to
       * previous and next Nodes.
       */
      private static class Node<E> {

         /** The element this Node holds. */
         private E element;

         /** A reference to the Node before this one. */
         private Node<E> prev;
      
         /** A reference to the Node after this one. */
         private Node<E> next;


         /** 
          * Create a new Node with the given element, adjacent nodes.
          *
          * @param elem  The element this Node holds.
          * @param prev  The Node which comes before this one.
          * @param next  The Node which comes after this one.
          */
         public Node(E elem, Node<E> prev, Node<E> next) {
            this.element = elem;
            this.prev = prev;
            this.next = next;
         }

         /** 
          * Return a string representation of this Node.
          *
          * @return A string representation of this Node.
          */
         public String toString() {
            return element.toString();
         }

      } // end class Node

   } // end class DLL

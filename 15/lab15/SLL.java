package lab15;

/**
 * This class implements singly linked lists.
 *
 * @author Iain Hewson
 */
public class SLL<E> {

   /** Specifies the first node in this SLL. */
   private Node<E> first;

   /** Construct an empty SLL. */
   public SLL() {
      this.first = null;
   }

   /**
    * Return the first element in this list, or null if list empty.
    * 
    * @return the first element in this list, or null if list empty.
    */
   public E getFirst() {
      return first == null ? null : first.element;
   }

   /**
    * Add the element elem to the start of the list.
    * 
    * @param elem the element to add to the list.
    */
   public void addFirst(E elem) {
      insert(elem, null);
   }

   /**
    * Add elem to the end of the list.
    * 
    * @param elem an element to add to the list.
    */
   public void addLast(E elem) {
      if (first == null) {
         insert(elem, null);
      } else {
         Node<E> curr = first;
         while (curr.next != null) {
            curr = curr.next;
         }
         insert(elem, curr);
      }
   }
   
   /**
    * Add the element elem after the element prev.  If prev is not in the
    * list then add elem at the end.
    * 
    * @param elem the element to add to the list.
    * @param prev the element to add elem after.
    */
   public void addAfter(E elem, E prev) {
      if (first == null) {
         insert(elem, null);
      } else {
         Node<E> curr = first;
         while (curr.next != null && !curr.element.equals(prev)) {
            curr = curr.next;
         }
         insert(elem, curr);
      }
   }
     

   /**
    *  Delete the first occurence of the element target from this SLL.
    *
    * @param target an element to delete from this SLL.
    */
   public void delete(E target) {
      Node<E> node = search(target);
      if (node == null) {
         return;
      } else if (node == first) {
         first = node.next;
      } else {
         Node<E> tmp = first;
         while (tmp.next != null && tmp.next != node) {
            tmp = tmp.next;
         }
         tmp.next = node.next;
      }
   }

   /**
    *  Returns the number of nodes in this SLL.
    *
    * @return the number of nodes in this SLL.
    */
   public int size() {
      int size = 0;
      for (Node<E> curr = first; curr != null; curr = curr.next) {
         size++;
      }
      return size;
   }

   /**
    *  String representation of SLL to allow System.out.println(aList).
    *
    * @return    A String representing this SLL.
    */
   public String toString() {
      StringBuilder s = new StringBuilder("[");
      for (Node<E> curr = first; curr != null; curr = curr.next) {
         s.append(curr.element);
         if (curr.next != null) {
            s.append(", ");
         }
      }
      return s.append("]").toString();
   }

   /**
    *  Insert elem at a given point in this SLL, either after the node prev, or
    *  before the first node if prev is null. 
    *
    * @param  elem  The element to store in the new node.
    * @param  prev  The node to store the new node after.
    */
   private void insert(E elem, Node<E> prev) {
      Node<E> newNode = new Node<E>(elem, null);
      if (prev == null) {
         newNode.next = first;
         first = newNode;
      } else {
         newNode.next = prev.next;
         prev.next = newNode;
      }
   }
   
   /**
    *  Find which (if any) node of this SLL contains an element equal to target.
    *  Return a link to the matching node (or null if there is none).
    *
    * @param  target  The element to search this SLL for.
    * @return  The first node in this list containing target (or null if there
    *          is none).
    */
   private Node<E> search(E target) {
      for (Node<E> curr = first; curr != null; curr = curr.next) {
         if (target.equals(curr.element)) {
            return curr;
         }
      }
      return null;
   }   

   /**
    * A simple container class which holds an element, and a reference to
    * the next Node.
    */
   private static class Node<E> {

      /** The element this Node holds. */
      private E element;

      /** Holds the Node after this one. */
      private Node<E> next;


      /** Create a new Node with the given element, adjacent nodes.
       *
       * @param elem the element this Node holds.
       * @param next the Node which comes after this one.
       */
      public Node(E elem, Node<E> next) {
         this.element = elem;
         this.next = next;
      }

      /** Return a string representation of this Node.
       *
       * @return a string representation of this Node.
       */
      public String toString() {
         return element.toString();
      }

   } // end class Node

}// end class SLL


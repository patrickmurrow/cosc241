package lab21;

public class DLL<E extends Comparable<E>> {

   private Node<E> first;

   private Node<E> last;

   public DLL() {
      first = null;
      last = null;
   }

   public E getFirst() {
      return first != null ? first.element : null;
   }
   
   public E getLast() {
      return last != null ? last.element : null;
   }

   public int size() {
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

   public void addFirst(E elem) {
      insert(elem, null);
   }
   
   public void addLast(E elem) {
      insert(elem, last);
   }
   
   public void addAfter(E elem, E prev) {
      if (search(prev) == null){
         insert(elem, last);
      }else{
         insert(elem, search(prev));
      }
   }

   
   public void delete(E elem) {
      Node<E> node = search(elem);
      if (node != null){
         if (node == first) { 
            first = node.next;
            if (first != null){
               first.prev = null;
            }else{
               last = null;
            }
         }else if(node == last) { 
            last = node.prev;
            last.next = null;
            
         }else { 
            node.prev.next = node.next;
            node.next.prev = node.prev; 
         }
      }
   }

   public int partition() {
      E p = first.element;
      Node<E> lo = first;
      Node<E> hi = last;
      int loIndex = 0;
      int hiIndex = size()-1;
      while (loIndex < hiIndex){
         while (p.compareTo(hi.element) <= 0 && loIndex != hiIndex){
            hi = hi.prev;
            hiIndex--;
         }
         if (hi != lo) {
            lo.element = hi.element;
            loIndex++;
            lo = lo.next;
         }
         while (p.compareTo(lo.element) >= 0 && loIndex != hiIndex){
            lo = lo.next;
            loIndex++;
         }
         if (hi != lo) {
            hi.element = lo.element;
            hiIndex--;
            hi = hi.prev;
         }
      }
      hi.element = p;
      return hiIndex; 
   }

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
 
   public String reverseString() {
      String result = "[";
      for (Node<E> curr = last; curr != null; curr = curr.prev) {
         result += curr;
         if (curr != first) {
            result += ", ";
         }
      }
      return result + "]";
   }
   
   private Node<E> search(E elem) {
      for (Node<E> curr = first; curr != null; curr = curr.next) {
         if (elem.equals(curr.element)) {
            return curr;
         }
      }
      return null;
   }

   private void insert(E elem, Node<E> prev) {
      Node<E> newNode = new Node<E>(elem, null, null);
      if (prev == null) {  
         newNode.next = first;
         if (first == null){ 
            last = newNode;
         }else { 
            first.prev = newNode;
         }
         first = newNode; 
      }else if(prev == last) {  
         last.next = newNode;
         newNode.prev = last;
         last = newNode; 
      }else { 
         newNode.next = prev.next;
         prev.next.prev = newNode;
         prev.next = newNode;
         newNode.prev = prev;  
      }
   }

   private static class Node<E> {

      private E element;

      private Node<E> prev;
      
      private Node<E> next;

      public Node(E elem, Node<E> prev, Node<E> next) {
         this.element = elem;
         this.prev = prev;
         this.next = next;
      }

      public String toString() {
         return element.toString();
      }

   }

}

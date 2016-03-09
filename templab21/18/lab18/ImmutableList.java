package lab18;

/**
 *  The objects of this class are immutable lists.  The methods are generally
 *  those of the List interface described in lectures except that they have to
 *  be modified slightly to represent that lists are immutable.
 * 
 * @author Iain Hewson
 */
public class ImmutableList<E> {

   /** The first element of this ImmutableList. */
   private E first;

   /** An ImmutableList which holds rest of this ImmutableLists elements. */
   private ImmutableList<E> rest;

   /** Constructs an empty ImmutableList. */
   public ImmutableList() {
      first = null;
      rest = null;
   }

   /**
    *  Constructs an ImmutableList with first as first element, rest as
    *  remaining elements.
    *
    * @param first the element to place at the start of the list.
    * @param rest the list which makes up the rest of this list.
    */
   public ImmutableList(E first, ImmutableList<E> rest) {
      this.first = first;
      this.rest = rest;
   }

   /**
    *  Returns true if this list is empty, otherwise false.
    *
    * @return true if empty, otherwise false.
    */
   public boolean isEmpty() {
      return first == null && rest == null;
   }

   /**
    *  Returns the number of elements in this list.
    *
    * @return the number of elements in this list.
    */
   public int size() {
      if (isEmpty()) {
         return 0;
      } else {
         return 1 + rest.size();
      }
   }

   /**
    *  Returns a string representation of this list.
    *
    * @return a string representation of this list.
    */
   public String toString() {
      return "[" + (isEmpty() ? "" : getContents()) + "]";
   }

   /**
    *  Recursively concatenates each element in this list adding a comma and a
    *  space between each element.
    *
    * @return a string made of the
    */
   private String getContents() {
      if (rest.isEmpty()) {
         return first.toString();
      } else {
         return first + ", " + rest.getContents();
      }
   }

   /**
    *  Returns the index of the given element in this list, or -1 if the
    *  element is not in this list.
    *
    * @param element an item to find the index of.
    * @return the (zero-based) index of element in this list, or -1 if element
    *         is not in this list.
    */
   public int indexOf(E element) {
      if (isEmpty()) {
         return -1;
      } else if (first.equals(element)) {
         return 0;
      }
      int index = rest.indexOf(element);
      if (index >= 0) {
         return 1 + index;
      } else {
         return -1;
      }
   }

   /**
    *  Decides whether this list equals the ImmutableList given as an
    *  argument.
    *
    * @param that a list to be tested for equality with this one.
    * @return true if and only if 'this' list and 'that' list have the same
    *         length, and each element of 'this' list equals the corresponding
    *         element of 'that' list.
    */
   public boolean equals(ImmutableList<E> that) {
      if (this.isEmpty() && that.isEmpty()){
         return true;
      } else if (this.isEmpty() != that.isEmpty()){
         return false;
      }
      return this.first.equals(that.first) &&
         this.rest.equals(that.rest);
   }

   /**
    *  Creates a new list like this except that a new item elem now occurs
    *  after the rest element.
    *
    * @param elem the additional element which the new list contains.
    * @return a new list which is the old list with elem appended to it.
    */
   public ImmutableList<E> add(E elem) {
      if (isEmpty()){
         return new ImmutableList<E>(elem, this);
      }
      return new ImmutableList<E>(first, rest.add(elem));
   }

   /**
    *  Makes a new list whose intial segment is a copy of this and whose
    *  final segment is the list that.
    *
    * @param that an ImmutableList whose elements get added to this.
    */
   public ImmutableList<E> addAll(ImmutableList<E> that) {
      if (isEmpty()){
         return that;    
      }
      return new ImmutableList<E>(first, rest.addAll(that));
   }

   /**
    *  Returns true if this list contains the given element, otherwise false.
    *
    * @param element an item search this list for.
    * @return true if this list contains the given element, otherwise false.
    */
   public boolean contains(E element) {
      // Implement this method
         if (this.first.equals(element)){
            return true;
         }
         else if (!rest.isEmpty()){
            return rest.contains(element);
         }
         return false;
   }

   /**
    *  Gets the element with index i in this list.
    *
    * @param i the index of the element to get from this list. 
    * @return the element with index i, or null if i is out of range.
    */
   public E get(int i) {
      // Implement this method
         if (i == 0){
            return this.first;
         }
         else if(!(i==0)){
            i--;
            return this.rest.get(i);
         }
         return null;
   }

   /**
    *  Creates a copy of this list except that the element at index i in this
    *  list has been replaced by elem (if i is out of range return the
    *  original list).
    *
    * @param i index at which to place the new element.
    * @param elem the new element to put in the list
    */
   public ImmutableList<E> set(int i, E elem) {
      // Implement this method
      ImmutableList<E> newList = this;
      if (i<this.size()){
         if (i == 0){
            return new ImmutableList<E>(elem, rest);
         }
         else{
            i--;
            newList = new ImmutableList<E> (this.first, rest.set(i, elem));
         }
      }
      return newList;
   }

   /**
    *  Makes a new list like this except that the element with index i has been
    *  removed.  If i is out of range, the returned list is the same.
    *
    * @param i the index of the element to remove.
    * @return a new list with the element at index i removed (if i is in
    *         range).
    */
   public ImmutableList<E> remove(int i) {
      // Implement this method
      ImmutableList<E> newList = this;
         if (i<this.size()){
            if (i == 0){
               return new ImmutableList<E>(this.rest.first, this.rest.rest);
            }
            i--;
            newList = new ImmutableList<E> (this.first, rest.remove(i));
         }
      
      return newList;
   }

}



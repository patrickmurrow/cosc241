package lab21;

public class ImmutableList<E> {

   private E first;

   private ImmutableList<E> rest;

   public ImmutableList() {
      first = null;
      rest = null;
   }

   public ImmutableList(E first, ImmutableList<E> rest) {
      this.first = first;
      this.rest = rest;
   }

   public boolean isEmpty() {
      return first == null && rest == null;
   }

   public int size() {
      if (isEmpty()) {
         return 0;
      } else {
         return 1 + rest.size();
      }
   }

   public String toString() {
      return "[" + (isEmpty() ? "" : getContents()) + "]";
   }

   private String getContents() {
      if (rest.isEmpty()) {
         return first.toString();
      } else {
         return first + ", " + rest.getContents();
      }
   }

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


   public boolean equals(ImmutableList<E> that) {
      if (this.isEmpty() && that.isEmpty()){
         return true;
      } else if (this.isEmpty() != that.isEmpty()){
         return false;
      }
      return this.first.equals(that.first) &&
         this.rest.equals(that.rest);
   }

   public ImmutableList<E> add(E elem) {
      if (isEmpty()){
         return new ImmutableList<E>(elem, this);
      }
      return new ImmutableList<E>(first, rest.add(elem));
   }

   public ImmutableList<E> addAll(ImmutableList<E> that) {
      if (isEmpty()){
         return that;    
      }
      return new ImmutableList<E>(first, rest.addAll(that));
   }

   public boolean contains(E element) {
      if (this.first.equals(element)){
         return true;
      }
      else if (!rest.isEmpty()){
         return rest.contains(element);
      }
      return false;
   }

   public E get(int i) {
      if (i == 0){
         return this.first;
      }
      else if(!(i==0)){
         i--;
         return this.rest.get(i);
      }
      return null;
   }

   public ImmutableList<E> set(int i, E elem) {
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

   public ImmutableList<E> remove(int i) {
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

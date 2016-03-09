package lab21;

public class BST<E extends Comparable<E>> {

   private E element;
   
   private BST<E> left, right;

   public BST() {
      left = right = null;
   }

   public BST(E element) {
      this.element = element;
      this.left = new BST<E>();
      this.right = new BST<E>();
   }

   private void becomes(BST<E> that) {
      this.left = that.left;
      this.right = that.right;
      this.element = that.element;
   }

   public boolean isEmpty() {
      return left == null && right == null;
   }

   public boolean isPresent(E target) {
      if (isEmpty()) {
         return false;
      }
      int direction = target.compareTo(element);
      if (direction == 0) {
         return true;
      }
      if (direction < 0) {
         return left.isPresent(target);
      }
      return right.isPresent(target);
   }

   public void insert(E element) {
      if (isEmpty()) {
         this.becomes(new BST<E>(element));
      } else {
         int direction = element.compareTo(this.element);
         if (direction == 0)         //it is already in the tree
            return;
         if (direction > 0)          //go right
            right.insert(element);
         else                        //go left
            left.insert(element);
      }
   }

   public void delete(E target) {
      // implement this method for lab 19
   }

   private E deleteMin() {
      // the next line is just to make the code compile
      return null;
      // implement this method for lab 19
   }

   /**  Deletes the root of this BST. */
   private void deleteRoot() {
      // implement this method for lab 19
   }

   public String toString() {
      return inOrder() + "\n" + preOrder() + "\n" + postOrder();
   }

   public String inOrder() {
      return "[" + (isEmpty() ? "" : inOrderAux()) + "]";
   }

   private String inOrderAux() {
      String result = "";
      if (!left.isEmpty()) {
         result += left.inOrderAux() + ", ";
      }
      result += element.toString();
      if (!right.isEmpty()) {
         result += ", " + right.inOrderAux();
      }
      return result;
   }

   public String preOrder() {
      String result = "[";
      if (!isEmpty()) {
         result += preOrderAux();
      }
      return result + "]";
   }

   private String preOrderAux() {
      String result = element.toString();
      if (!left.isEmpty()) {
         result += ", " + left.preOrderAux();
      }
      if (!right.isEmpty()) {
         result += ", " + right.preOrderAux();
      }
      return result;
   }

   public String postOrder() {
      String result = "[";
      if (!isEmpty()) {
         result += postOrderAux();
      }
      return result + "]";
   }

   private String postOrderAux() {
      String result = "";
      if (!left.isEmpty()) {
         result += left.postOrderAux() + ", ";
      }
      if (!right.isEmpty()) {
         result += right.postOrderAux() + ", ";
      }
      return result + element;
   }
}

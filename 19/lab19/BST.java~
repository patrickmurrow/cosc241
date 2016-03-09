package lab19;

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
         if (direction == 0)       
            return;
         if (direction > 0)         
            right.insert(element);
         else                        
            left.insert(element);
      }
   }
   
   public void delete(E target) {
      if (element  == null) return;
      
      int comparison = element.compareTo(target);
     
      if (comparison < 0) {
         if (right != null) right.delete(target);
         return;
      }

      if (comparison > 0) {
         if (left != null) left.delete(target);
         return;
      }

      deleteRoot();
   }

   private E deleteMin() {
      if (!left.isEmpty()){
         return left.deleteMin();
      }
      E value = element;
      becomes(right);
      return value;
   }

   private void deleteRoot() {
      if (left.isEmpty() && right.isEmpty()) {
         left = null;
         right = null;
         return;
      }

      if (right.isEmpty()) {
         becomes(left);
         return;
      }

      if (left.isEmpty()) {
         becomes(right);
         return;
      }
       
      element = right.deleteMin();
      
   }

   /**
    *  Returns a string representation of the BST.  The representation
    *  consists of in-order, pre-order and post-order lists of each
    *  element in this BST on separate lines.
    *
    * @return  a string representation of this BST.
    */
   public String toString() {
      return inOrder() + "\n" + preOrder() + "\n" + postOrder();
   }

    /**
    *  Returns an in-order concatenation of the elements in this BST,
    *  surrounded by square brackets.
    *
    * @return an inorder concatenation of the elements in this BST.
    */
   public String inOrder() {
      return "[" + (isEmpty() ? "" : inOrderAux()) + "]";
   }

   /**
    *  Performs a recursive in-order traversal of this BST
    *  concatenating each element with a comma and a space in between.
    *
    * @return an in-order concatenation of the elements in this BST.
    */
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

   /**
    *  Returns a pre-order concatenation of the elements in this BST,
    *  surrounded by square brackets.
    *
    * @return a pre-order concatenation of the elements in this BST.
    */
   public String preOrder() {
      String result = "[";
      if (!isEmpty()) {
         result += preOrderAux();
      }
      return result + "]";
   }

   /**
    *  Performs a recursive pre-order traversal of this BST
    *  concatenating each element with a comma and a space in between.
    *
    * @return a pre-order concatenation of the elements in this BST.
    */
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

   /**
    *  Returns a post-order concatenation of the elements in this BST,
    *  surrounded by square brackets.
    *
    * @return a post-order concatenation of the elements in this BST.
    */
   public String postOrder() {
      String result = "[";
      if (!isEmpty()) {
         result += postOrderAux();
      }
      return result + "]";
   }

   /**
    *  Performs a recursive post-order traversal of this BST
    *  concatenating each element with a comma and a space in between.
    *
    * @return a post-order concatenation of the elements in this BST.
    */
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

   /**
    * Returns a String representation of this BST as a tree on its side with
    * the root at the left. 
    *
    * @return    An indented String representation of this BST.
    */
   public String toPrettyString() {
      return toPrettyString("");
   }

   /**
    *  A recursive method which returns a String representation of this BST as
    *  a tree on its side with the root at the left.
    *
    * @param  spaces  A String of spaces used to create the appropriate indent.
    * @return         An indented String representation of this BST.
    */
   private String toPrettyString(String spaces) {
      if (isEmpty()) {
         return "";
      } else {
         return right.toPrettyString(spaces + "     ") +
            (right.isEmpty() ? "" : spaces + "  /\n") +
            spaces + element + "\n" +
            (left.isEmpty() ? "" : spaces + "  \\\n") +
            left.toPrettyString(spaces + "     ");
      }
      // Note: the format for a conditional expression in Java is:
      //    i = (condition) ? expressionOne : expressionTwo;
      // This is the same as:
      //    if (condition) {
      //       i = expressionOne;
      //    } else {
      //       i = conditionTwo;
      //    }
   }

}


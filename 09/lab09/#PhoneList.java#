/* File: Palindrome.java - March 2014 */
package lab09;

import java.util.*;

/**
 * This Class creates and edits a HashMap "phonebook"
 *
 * @author Patrick Murrow
 */
public class PhoneList {
   Map<String,String> plist = new HashMap<String,String>();

   public PhoneList(){
   }

   /**
    * Finds the corresponding number of the given input name using the HashMap
    * get() method
    * 
    * @return the number of the given input name in the list
    * @params gName - user given input name
    */
   public String getNumber(String gName) {
      return plist.get(gName);  
   }
   
   /**
    * Sees if the given input name is contained within the HashMap using the
    * HashMap containsKey() method
    * 
    * @return true or false, in the list or not
    * @params cName - user given input name
    */
   public boolean contains(String cName) {
      return plist.containsKey(cName);
   }

   /**
    * Adds the name and number to the HashMap using HashMap put() method 
    * 
    * @params name - user given string. number - user given string
    */
   public void addEntry(String name, String number) {
      plist.put(name, number);
   }

   /**
    * Finds the size of the HashMap using it's size() method
    * 
    * @return the size of the HasMap
    */
   public int size(){
      return plist.size();
     }

   /**
    * Removes the given name and it's number from the HashMap using the
    * remove() method
    * 
    * @return empty string
    * @params rName - user given name to remove
    */
   public String remove(String rName){
      return plist.remove(rName);
    }                                  

   /**
    * Uses HashMap toString() method to return the HashMap
    * 
    * @return all of the contents in the HashMap
    */
   public String toString() {
      return plist.toString();
   }

}

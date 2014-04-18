//CSE 143 HW1 Quiz Section AA TA: 
//Date: April 11,2013
//Student name: Shijia Bian 
//Student ID: 
//Program Description: Class LetterInventory is used to keep track of an inventory 
//of letters of the alphabet. It can also be used to add or subtract from an inventory

import java.util.*;

public class LetterInventory {
   private int[] elementData; //list of alphabet to store the occurence of letter
   private int size;          //current number of elements in the list
      
   public static final int DEFAULT_CAPACITY = 26;
   
   //Post: construct an arraylist with 26 spaces. In terms of the string given by the 
   //client, each of the space will record the number of occurence of each alphebat.
   public LetterInventory(String data) {
      size = data.length();
      elementData = new int[DEFAULT_CAPACITY];
      for (int i = 0; i < data.length(); i++) {
         char ch = Character.toLowerCase(data.charAt(i)); 
         if (Character.isLetter(ch)){
           elementData[ch - 'a']++; 
         }else{
            size--;
         }          
      }
    }
    
    //Pre: non-alphebat character or value < 0 -> throw new IllegalArgumentException()
    //Post:Sets the count for the given letter to the given value, letter can be lower 
    //or upper cases
    public void set(char letter, int value) {
      if (!Character.isLetter(letter) || value < 0)
         throw new IllegalArgumentException();
      int index = Character.toLowerCase(letter) - 'a';
      size += value - elementData[index]; 
      elementData[index] = value;
    }
    
   //Pre: the 'letter; has to be letter, otherwise,throw new IllegalArgumentException();
   //Post: return the counts in the inventory
   public int get(char letter) {
      if (!Character.isLetter(letter))
         throw new IllegalArgumentException();  
      return elementData[Character.toLowerCase(letter) - 'a'];
   }
   
   // Pre:the inventory is empty
   // Post: return size == 0 
   public boolean isEmpty() {
      return size == 0;
   }

   //Post: return the sum of size in the inventory
   public int size() {
      return size;
   }
   
   //post: creates a bracketed version of the list  
   public String toString() {
      String result = "[";
      for (int i = 0; i < DEFAULT_CAPACITY; i++) {
         for (int j = 0; j < elementData[i]; j++) {
            result += (char)('a' + i); 
         }
      }       
      result += "]";
      return result;
   }
   
   //Post:Constructs and returns a new LetterInventory object that represents 
   //the sum of this letter inventory and the other given LetterInventory.  
   public LetterInventory add (LetterInventory other) {
      LetterInventory result = new LetterInventory("");
      for (int i = 0; i < DEFAULT_CAPACITY; i++) {
         char letter = (char) (i + 'a');
         int value = elementData[i] + other.get(letter);
         result.set(letter, value);
      }
      return result;
   }

   //Posts:Constructs and returns a new LetterInventory object that represents 
   //the result of subtracting the other inventory from this inventory 
   public LetterInventory subtract (LetterInventory other) {
      LetterInventory result = new LetterInventory("");
      for (int i = 0; i < DEFAULT_CAPACITY; i++) {
         char letter = (char) (i + 'a');
         if(elementData[i] < other.get(letter)){
            return null;
         }
         int value = elementData[i] - other.get(letter);
         result.set(letter, value);
      }
      return result;
   }
}
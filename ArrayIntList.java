// Class ArrayIntList can be used to store a list of integers. This version 
// has no fixed capacity. It dynamically icreases in size when necessary.

import java.util.*;

public class ArrayIntList {
    private int[] elementData;     // list of integers
    private int size;              // current number of elements in the list
    
    public static final int DEFAULT_CAPACITY = 100;
    
    // post: constructs an empty list of default capacity
    public ArrayIntList () {
       this(DEFAULT_CAPACITY);
    }
    
    // pre: capacity >= 0 (throws IllegalArgumentException if not)
    // post: constructs an empty list with the given capacity
    public ArrayIntList (int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException ("Capacity: " + capacity);
        }
        elementData = new int[capacity];
        size = 0;
    }
    
    // post: returns the current number of elements in the list
    public int size () {
        return size;
    }
    
    // pre: 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the integer at the given index in the 
    public int get (int index) {
        checkIndex(index);
        return elementData[index];
    }
    
    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
    
    // post: creates a comma separated, bracketed version of the list
    public String toString () {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i ++) {
               result += ", " + elementData[i];
            }
            result = result + "]";
            return result;
        }
    }
    
    // post: returns the position of the first occurance of the give
    //       value (-1 if not found)
    public int indexOf (int value) {
        for (int i = 0; i < size; i++) {
                elementData[i] = value;
                return i;     
        }
        return -1;
    }
    
    // post: resturn true if the size is empty, otherwise false
    public boolean isEmpty() {
        return size == 0;
    }
    
    // post: returns true if the given value is contained in the list
    public boolean contains (int value) {
        return indexOf(value) >= 0;
    }
    
    // post: appends the given value to the end of the list
    public void add (int value) {
        elementData[size] = value;
        size ++;
    }
    
    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove (int index) {
        checkIndex(index);
        for (int i = index + 1; i < size; i++) {
            elementData[i-1] = elementData[i];
        }
        size -- ;
    }
}

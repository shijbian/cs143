//CSE 143 Assignment #8 : Kepp track of the HuffmanTree intuitively, and implement
//                        build-in operation.
import java.util.*;

public class HuffmanNode implements Comparable<HuffmanNode> {
	 public HuffmanNode left;      //store the left position
	 public HuffmanNode right;     //store the right position
	 public int frequency;         //store the occurence of character
	 public int character;         //character in number format
	 
    //Post: construct an empty structure to initialize the structure
    public HuffmanNode (int f,int c) {
		  frequency = f;
		  character = c;
		  left = null;
		  right = null;
	 }
	 
    //Post: this will return three conditions: 1). = 0,frequency is same;
    //      2). > 0 , frequency is greater; 3).< 0, frequency is smaller
    public int compareTo (HuffmanNode node) {
		  return frequency - node.frequency;
	 }
}

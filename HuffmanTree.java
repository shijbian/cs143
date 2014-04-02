//CSE 143 Assignment #8: Huffman coding is an algorithm used for lossless data compression.
//                       The client will pass a text file, this program will compress 
//                       this text file based on the frequency of characters. The huffman 
//                       code will use less bits for the more frequent characters but more 
//                       bits for the less frequent characters. It will also decompress the 
//                       file in the opposite direction.       
                  
import java.util.*;
import java.io.*;

public class HuffmanTree {
	 public static final int CHAR_MAX = 256;    // ASCII value for character: 0-255
	 private HuffmanNode rootNode;
	 private HuffmanNode decodeRoot;
	 
    // Post: read the text from the file 
    public HuffmanTree (Scanner input) {
		  decodeRoot = new HuffmanNode(0, 0);
		  String code;
	     while (input.hasNextLine()) {
            int n = Integer.parseInt (input.nextLine());
            code = input.nextLine();
            buildDecodeBranch (code, n);
        }
    }
    
    // Pre: frequency is not negative
    // Post: count number of occurences of the characters until we count all the letters
	 public HuffmanTree (int[] count) {
		  PriorityQueue<HuffmanNode> queueForNodes = new PriorityQueue<HuffmanNode> (count.length);
		  for (int i = 0; i < count.length; i++)
		  if(count[i]>0) { 
            queueForNodes.add (new HuffmanNode (count[i], i));
		  }
		  queueForNodes.add (new HuffmanNode(1, CHAR_MAX));
		  buildHuffManTree (queueForNodes);
	 }
    
    //Pre: Input stream contains a legal encoding of characters for this  tree's
    //     Huffman code.
    //Post: read bits and generate the output with the corresponding character.
	 public void decode (BitInputStream input, PrintStream output, int charMax) {
		  if(decodeRoot == null) 
            throw new IllegalStateException ("Haven't read the codefile yet.");
		  HuffmanNode node = decodeRoot;
		  int i;
		  while ((i = input.readBit()) != -1) { 
		      if (i == 0)
				    node = node.left;
			   else 
				    node = node.right;
			   // not a leaf node, continue to read a bit;
			   if (node.character == 0) 
                continue;
			   // find the end of file;
			   if (node.character == CHAR_MAX) 
                break;
			   //find a character, write it to the stream,and reset the node.
			   output.write (node.character);
			   node = decodeRoot;
        }
    }
    
    // Post: This will convert the input into the standard format. 
    public void write (PrintStream output) {
		  traversalTree (output, rootNode, "");
	 }
	
    //Post: output the node information to the target in the given format.
	 private void traversalTree (PrintStream output, HuffmanNode root, String code) {
		  if (root.character != 0) {
			   output.println ((int)root.character);
			   output.println (code);
			   return;
		  }
		  traversalTree (output, root.left, code + '0');
		  traversalTree (output, root.right, code + '1');
    }
	 
    //Post: Help to build the HuffManTree standard format by the frequency
    private void buildHuffManTree (PriorityQueue<HuffmanNode> queueForNodes) {
		  while (queueForNodes.size() > 1) {
			   HuffmanNode root = new HuffmanNode (0, (byte)0);
			   root.left = queueForNodes.poll();
			   root.right = queueForNodes.poll();
			   root.frequency = root.left.frequency + root.right.frequency;
			   queueForNodes.add(root);
		  }
        rootNode = queueForNodes.poll();
	 }
    
    //Post: help to generate the output with the corresponding character.
	 private void buildDecodeBranch (String code,int character) {
		  HuffmanNode node = decodeRoot;
		  for (int i = 0; i < code.length(); i++) {
			   if (code.charAt(i) == '0') {
				    if (node.left == null) 
                    node.left = new HuffmanNode (0, 0);
				    node=node.left;
			   } else {
				    if (node.right == null) 
                    node.right = new HuffmanNode(0, 0);
				    node=node.right;
			   }
		  }
		  node.character = character;
	 }
}

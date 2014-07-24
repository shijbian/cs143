import java.util.*;
import java.io.*;

// Notes: 
// translation from array to ArrayList:
//    String[]           => ArrayList<String>
//    new String[10]     => new ArrayList<String>()
//    a.length           => list.size()
//    a[i]               => list.get(i)
//    a[i] = value       => list.set(i, value)
// new operations:
//    list.remove(i);      -- remove the ith value
//    list.add(value);     -- appends a value
//    list.add(i, value);  -- add at an index
//    list.clear();        -- remove all value
//    list.toString();     -- nice String of the list
//
// Wrapper classes (for primitives):
//    int      => Integer
//    double   => Double
//    char     => Character
//    boolean  => Boolean

public class Monday {
   public static void main (String[] args) throws FileNotFoundException {       
       // Array version of reading a file into an array.
       String[] lines = new String[1000];
       Scanner input = new Scanner(new File("data.txt"));
       int lineCount = 0;
       while (input.hasNextLine()) {
           String line = input.nextLine();
           lines[lineCount] = line;
           lineCount ++;
       }
       
       System.out.println(lines[0]);
       System.out.println(lines[lineCount - 1]);
       
       // ArrayList version of reading a file into an ArrayList.
       ArrayList<String> lines2 = new ArrayList<String>();
       Scanner input2 = new Scanner(new File("data.txt"));
       while (input2.hasNextLine()) {
         String line2 = input2.nextLine();
         lines2.add(line2);
       }
       
       System.out.println(lines2.get(0));
       System.out.println(lines2.get(lines2.size()-1));
       
       // Manupulating ArrayLists for integer values
       ArrayList<Integer> list2 = new ArrayList<Integer>();
       list2.add(1);
       list2.add(-1);
       list2.add(42);  
       int numElements = list2.size();
       int first = list2.get(0);
       System.out.println(list2);
   }
} 


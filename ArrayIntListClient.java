public class ArrayIntListClient {
    public static void main(String[] args) {
    // construct ArrayIntList list1
    // construct ArrayIntList list2
    ArrayIntList list1 = new ArrayIntList(500);
    ArrayIntList list2 = new ArrayIntList();
    
    // add 1, 82, 97 to list1
    list1.add(1);
    list1.add(82);
    list1.add(97);
    // add 7, -8 to list2
    list2.add(7);
    list2.add(-8);
    
    // print list1
    System.out.println(list1);
    System.out.println(list1.size());
    
    // print list2
    System.out.println(list2.toString());
    }
}

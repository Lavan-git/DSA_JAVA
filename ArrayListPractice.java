import java.util.*;
public class ArrayListPractice {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<ArrayList<Integer>> multiList=new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        multiList.add(list);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        multiList.add(list2);
        System.out.println(multiList);

    }
}

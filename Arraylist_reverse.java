import java.util.*;
public class Arraylist_reverse {
    public static void main(String[] args) {        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);list.add(3);list.add(4);list.add(5);
        System.out.println("Original List: "+list);
        System.out.println("New list: ");
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+" ");
        }
    }
}

import java.util.*;
public class Arraylist_pairsum_bruteforce {
    public static ArrayList<ArrayList<Integer>> pairSum(ArrayList<Integer> list, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if((list.get(i)+list.get(j))==target){
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(list.get(i));
                    pair.add(list.get(j));
                    result.add(pair);
                }
            }
        }
        return result;
    };
    public static void main(String[] args) {
        //1,2,3,4,5,6
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);        
        System.out.println(pairSum(list, 5));
    }
}

import java.util.ArrayList;

public class Arraylist_pairsum_2pointer {
    public static ArrayList<ArrayList<Integer>> pairSum(ArrayList<Integer> list, int target) {
        int lp=0;int rp=list.size()-1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        while(lp<rp) {

            if((list.get(lp)+list.get(rp))>target){
                rp--;
            }else if((list.get(lp)+list.get(rp))==target){
                ArrayList <Integer> pair = new ArrayList<>();
                pair.add(list.get(lp));
                pair.add(list.get(rp));
                result.add(pair);
                lp++;rp--;
            }
            else{lp++;}

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

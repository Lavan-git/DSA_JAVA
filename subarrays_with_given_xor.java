import java.util.*;
public class subarrays_with_given_xor {
    public static void main(String[] args) {
        int arr[]={4, 2, 2, 6, 4};
        int k=6;
        HashMap<Integer,Integer> map=new HashMap<>();
        // (xor,count) pair
        map.put(0,1);
        int count=0;
        int xor=0;
        for(int i:arr){
            xor^=i;
            if(map.containsKey(xor^k)){
                count+=map.get(xor^k);
            }
            map.put(xor,map.getOrDefault(xor, 0)+1);
        }
        System.out.print(count);
    }
}

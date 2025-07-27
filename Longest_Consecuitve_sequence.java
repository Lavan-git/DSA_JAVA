import java.util.*;
public class Longest_Consecuitve_sequence {
    public static void main(String[] args) {
        int nums[]={100,4,200,1,3,2};
        HashSet<Integer> hs= new HashSet<>();
        for(int i:nums){
            hs.add(i);
        }
        int max=0;
        int curr;
        int count;
        for(int i:hs){
            curr=i;
            count=1;
            if(!hs.contains(curr-1)){
                while(hs.contains(curr+1)){
                    curr++;
                    count++;
                }
                max=Math.max(count,max);
            }
        }
        System.out.print(max);
    }
}

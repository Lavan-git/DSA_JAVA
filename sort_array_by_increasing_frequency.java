import java.util.HashMap;
import java.util.TreeSet;

public class sort_array_by_increasing_frequency {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int nums[]={1,1,2,2,2,3};
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
        }
        TreeSet<HashMap.Entry<Integer,Integer>> ts=new TreeSet<>((a,b)->{
            if(!a.getValue().equals(b.getValue())){
                return a.getValue()-b.getValue();
            }else{
                return a.getKey()-b.getKey();
            }
        });
        ts.addAll(map.entrySet());
        for(HashMap.Entry<Integer,Integer> en:ts){
            int freq=en.getValue();
            int num=en.getKey();
            for(int i=0;i<freq;i++){
                System.out.print(num+" ");
            }
        }
    }
}

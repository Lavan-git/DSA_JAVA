import java.util.HashMap;

public class Largest_subarray_with_0_sum {
    public static void main(String[] args) {
        int arr[]={15,-2,2,-8,1,7,10,23};
        HashMap<Integer,Integer> map=new HashMap<>();
        int size=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0){size=i+1;}
            if(map.containsKey(sum)){
                size=Math.max(size,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        System.out.println("The size is:"+size);
    }
}

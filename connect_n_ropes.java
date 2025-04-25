import java.util.*;
public class connect_n_ropes {
    public static int solution(int[] arr){
        int result=0;
        PriorityQueue<Integer> p=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            p.add(arr[i]);
        }
        while(p.size()>1){
            int a=p.poll();
            int b=p.poll();
            result+=a+b;
            p.add(a+b);
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[]={4,3,2,6};
        System.out.println(solution(arr));
    }
}

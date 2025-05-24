import java.util.*;
public class sliding_window_max_1 {
    public static int[] solution(int arr[],int k){
        Deque<Integer> dq=new LinkedList<>();
        int idx=0;
        int n=arr.length;
        int res[]=new int[n-k+1];
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.getFirst()<=i-k)
                dq.removeFirst();
            while(!dq.isEmpty() && arr[dq.getLast()]<=arr[i])
                dq.removeLast();
            dq.addLast(i);
            if(i>=k-1)
                res[idx++]=arr[dq.getFirst()];
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        int res[]=solution(arr, k);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}

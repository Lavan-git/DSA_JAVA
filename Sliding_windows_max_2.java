import java.util.*;
public class Sliding_windows_max_2 {
    public static class info{
        int val;
        int idx;
        public info(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
    }
    public static int[] solution(int arr[],int k){
        int n=arr.length;
        PriorityQueue<info> pq=new PriorityQueue<>((a,b)->b.val-a.val);
        int idx=0;
        int res[]=new int[n-k+1];
        for(int i=0;i<n;i++){
            while(!pq.isEmpty() && pq.peek().idx<=i-k){
                pq.remove();
            }
            pq.add(new info(arr[i],i));
            if(i>=k-1){
                res[idx++]=pq.peek().val;
            }
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

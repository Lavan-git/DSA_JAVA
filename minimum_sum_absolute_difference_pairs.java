import java.util.*;
public class minimum_sum_absolute_difference_pairs {
    public static int solution(int arr[],int arr2[]){
        int res=0;
        Arrays.sort(arr);
        Arrays.sort(arr2);
        for(int i=0;i<arr.length;i++){
            res+=Math.abs(arr[i]-arr2[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {4,1,8,7};
        int[] arr2={2,3,6,5};
        System.out.println(solution(arr,arr2));

    }
}

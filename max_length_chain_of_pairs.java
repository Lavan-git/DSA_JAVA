import java.util.*;

public class max_length_chain_of_pairs {
    public static int find(int[][] pairs) {
        
        int arr[][]=new int[pairs.length][3];
        for(int i=0;i<pairs.length;i++){
            arr[i][0]=i;
            arr[i][1]=pairs[i][0];
            arr[i][2]=pairs[i][1];
        }
        Arrays.sort(arr,Comparator.comparingInt(o->o[2]));
        System.out.println(Arrays.deepToString(arr));
        int ans=1;
        int curr_end=arr[0][2];
        for(int i=1;i<arr.length;i++){
            if(arr[i][1]>curr_end){
                curr_end=arr[i][2];
                ans++;
            }
        }
        return ans;


    }

    public static void main(String[] args) {
        int pairs[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};
        System.out.println(find(pairs));

    }
}

import java.util.Arrays;
import java.util.Comparator;

public class fractional_knapsack {
    public static double solution(int[] val,int[] wt,int W){
        double max=0;
        int n=val.length;
        double arr[][]=new double[n][4];
        for(int i=0;i<n;i++){
            arr[i][0]=i;
            arr[i][1]=val[i];
            arr[i][2]=wt[i];
            arr[i][3]=((double)val[i]/wt[i]);
        }
        Arrays.sort(arr,Comparator.comparingDouble((double[] o)->o[3]).reversed());
        System.out.println(Arrays.deepToString(arr));
        for(int i=0;i<n;i++){
            if(W>=arr[i][2]){
                W-=arr[i][2];
                max+=arr[i][1];
            }else{
                double f=(double)W/arr[i][2];
                max+=arr[i][1]*f;
                break;
            }
        }
        return max;
    }
    public static void main(String[] args) {        
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};        
        int W = 50;
        System.out.println("The maximum value of items that can be carried is: " + solution(val,wt,W));
        
    }
}

import java.util.*;
public class Longest_Increasing_subsequence {
    public static int recursion(int arr[],int arr2[],int n,int m){
        if(n==0 || m==0){return 0;}
        if(arr[n-1]==arr2[m-1]){
            return 1+recursion(arr, arr2, n-1, m-1);
        }else{
            return Math.max(recursion(arr, arr2, n-1, m),recursion(arr, arr2, n, m-1));
        }
    }
    public static int memoization(int arr[],int arr2[],int n,int m,int dp[][]){
        if(n==0 || m==0){return 0;}
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(arr[n-1]==arr2[m-1]){
            dp[n][m]= 1+memoization(arr, arr2, n-1, m-1,dp);
            return dp[n][m];
        }else{
            dp[n][m]= Math.max(memoization(arr, arr2, n-1, m,dp),memoization(arr, arr2, n, m-1,dp));
            return dp[n][m];
        }
    }
    public static int tabulation(int arr[],int arr2[],int n,int m){
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr[i-1]==arr2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        int arr[]=new int[]{50,3,10,7,40,80};
        TreeSet<Integer> ts=new TreeSet<>();
        for(int i:arr){ts.add(i);}

        int n=arr.length;
        int arr2[]=new int[ts.size()];
        int k=0;
        for(int i:ts){arr2[k++]=i;}
        int dp[][]=new int[n+1][n+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        //System.out.println(memoization(arr,arr2,n,n,dp));
        System.out.println(tabulation(arr, arr2, n, n));
    }
}

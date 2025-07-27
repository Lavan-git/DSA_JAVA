import java.util.Arrays;

@SuppressWarnings("unused")
public class zero_one_knapsack {
    public static int recursion(int val[],int wt[],int W,int n){
        if(n==0 || W==0){
            return 0;
        }
        // including item
        // 1 case, we can include, and then make other call, 2nd case, we are not able to include due to W being small
        if(wt[n-1]<=W){
            //include
            int ans1= val[n-1]+recursion(val, wt, W-wt[n-1], n-1);
            
            //exlude
            int ans2=recursion(val, wt, W, n-1);
            return Math.max(ans1, ans2);
        }else{
            return recursion(val, wt, W, n-1);
        }
    }
    public static int memoization(int val[],int wt[],int W,int n,int dp[][]){
        if(n==0 || W==0){
            return 0;
        }
        if(dp[n][W]!=-1){return dp[n][W];}
        // including item
        // 1 case, we can include, and then make other call, 2nd case, we are not able to include due to W being small
        if(wt[n-1]<=W){
            //include
            int ans1= val[n-1]+memoization(val, wt, W-wt[n-1], n-1,dp);
            
            //exlude
            int ans2=memoization(val, wt, W, n-1,dp);
            dp[n][W]= Math.max(ans1, ans2);
            return dp[n][W];
        }else{
            dp[n][W]=memoization(val, wt, W, n-1,dp);
            return dp[n][W];
        }
    }
    public static int tabulation(int val[],int wt[],int W,int dp[][]){
        int n=val.length;
        // rows are items, columns are different weights
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                if(wt[i-1]<=j){
                    //include
                    int ans1=val[i-1]+dp[i-1][j-wt[i-1]];
                    //exclude
                    int ans2=dp[i-1][j];
                    dp[i][j]=Math.max(ans1,ans2);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;
        int n=5;
        int dp[][]=new int[n+1][W+1];
        //for(int row[]:dp){Arrays.fill(row,-1);}
        System.out.println(tabulation(val, wt, W,dp));
        for(int row[]:dp){
            for(int i:row){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        
    }
}

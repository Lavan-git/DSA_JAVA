import java.util.*;;
public class unbounded_knapsack {
    public static int recursion(int val[],int wt[],int W,int n){
        if(n==0 || W==0){
            return 0;
        }
        if(W>=wt[n-1]){
            //include 
            int inc=val[n-1]+recursion(val, wt, W-wt[n-1], n);
            int exc=recursion(val, wt, W, n-1);
            return Math.max(inc,exc);
        }else{
            return recursion(val, wt, W, n-1);
        }
    }
    public static int memoization(int val[],int wt[],int W,int n,int dp[][]){
        if(n==0 || W==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        if(W>=wt[n-1]){
            //include 
            int inc=val[n-1]+memoization(val, wt, W-wt[n-1], n,dp);
            int exc=memoization(val, wt, W, n-1,dp);
            dp[n][W]= Math.max(inc,exc);
            return dp[n][W];
        }else{
            dp[n][W]= memoization(val, wt, W, n-1,dp);
            return dp[n][W];
        }
    }
    public static int tabulation(int val[],int wt[],int W,int n,int dp[][]){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                if(wt[i-1]<=j){
                    int inc=val[i-1]+dp[i][j-wt[i-1]];
                    int exc=dp[i-1][j];
                    dp[i][j]=Math.max(inc,exc);
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
        int W=700;
        int n=5;
        int dp[][]=new int[n+1][W+1];
        System.out.println(recursion(val, wt, W, n));
        //for(int row[]:dp){Arrays.fill(row,-1);}
        //System.out.println(memoization(val, wt, W, n,dp));
        //System.out.println(tabulation(val, wt, W, n, dp));
        // for(int i[]:dp){
        //     for(int j:i){
        //         System.out.print(j+" ");
        //     }
        //     System.out.println();
        // }
    }
}

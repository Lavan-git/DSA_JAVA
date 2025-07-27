public class climbing_stairs {
    public static int climb_recursion(int n){
        if(n==0){return 1;}
        if(n<0){return 0;}
        return climb_recursion(n-1)+climb_recursion(n-2);
    }
    public static int climb_memo(int n,int dp[]){
        if(n==0){return 1;}
        if(n<0){return 0;}
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n]=climb_memo(n-1,dp)+climb_memo(n-2,dp);
        return dp[n];
    }
    public static int climb_tab(int n,int dp[]){
        if(n==0){return 1;}
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println(climb_tab(n,new int[n+1]));
    }
}

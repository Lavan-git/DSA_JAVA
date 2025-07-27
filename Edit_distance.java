import java.util.*;
public class Edit_distance {
    public static int recursion(String word1,String word2,int n,int m) {
        if(m==0 ){return n;}if(n==0)return m;
        if(word1.charAt(n-1)==word2.charAt(m-1)){
            return recursion(word1, word2, n-1, m-1);
        }else{
            //add
            int add=1+recursion(word1, word2, n, m-1);
            //delete
            int delete=1+recursion(word1, word2, n-1, m);
            //replace
            int replace=1+recursion(word1, word2, n-1, m-1);
            return Math.min(Math.min(add,delete),replace);
        }
    }
    public static int memoization(String word1,String word2,int n,int m,int dp[][]){
        if(m==0 ){return n;}if(n==0)return m;
        if(dp[n][m]!=-1){return dp[n][m];}
        if(word1.charAt(n-1)==word2.charAt(m-1)){
            dp[n][m]= memoization(word1, word2, n-1, m-1,dp);
            return dp[n][m];
        }else{
            //add
            int add=1+memoization(word1, word2, n, m-1,dp);
            //delete
            int delete=1+memoization(word1, word2, n-1, m,dp);
            //replace
            int replace=1+memoization(word1, word2, n-1, m-1,dp);
            dp[n][m]=Math.min(Math.min(add,delete),replace);
            return dp[n][m];
        }
    }
    public static int tabulation(String word1,String word2,int n,int m){
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=m;i++){dp[0][i]=i;}
        for(int i=0;i<=n;i++){dp[i][0]=i;}
        for(int i=1;i<=n;i++){for(int j=1;j<=m;j++){
            if(word1.charAt(i-1)==word2.charAt(j-1)){dp[i][j]=dp[i-1][j-1];}else{dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));}
        }}
        for(int i[]:dp){for(int j:i){System.out.print(j+" ");}System.out.println();}
        return dp[n][m];
    }
    public static void main(String[] args) {
        String word1="intention";
        String word2="execution";
        int n=word1.length();
        int m=word2.length();
        // int[][] dp=new int[n+1][m+1];
        // for(int i[]:dp){Arrays.fill(i,-1);}
        // System.out.println(memoization(word1, word2, n, m,dp));
        System.out.println(tabulation(word1, word2, n, m));

        
    }
}

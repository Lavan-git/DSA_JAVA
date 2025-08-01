public class String_conversion_dp {
    public static int dp_tabulation(String word1,String word2,int n,int m){
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=m;i++){dp[0][i]=i;}
        for(int i=0;i<=n;i++){dp[i][0]=i;}
        for(int i=1;i<=n;i++){for(int j=1;j<=m;j++){
            if(word1.charAt(i-1)==word2.charAt(j-1)){dp[i][j]=dp[i-1][j-1];}else{dp[i][j]=1+Math.min(dp[i-1][j],dp[i][j-1]);}
        }}
        for(int i[]:dp){for(int j:i){System.out.print(j+" ");}System.out.println();}
        return dp[n][m];
    }
    public static int LCS_tabulation(String word1,String word2,int n,int m){
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){for(int j=1;j<=m;j++){if(word1.charAt(i-1)==word2.charAt(j-1)){dp[i][j]=1+dp[i-1][j-1];}else{dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);}}}
        return dp[n][m];
    }
    public static void main(String[] args) {
        String str1="pear";
        String str2="sea";
        int n=str1.length();
        int m=str2.length();
        System.out.print("Answer is "+(n+m-2*LCS_tabulation(str1, str2, n,m)));
    }
    
}

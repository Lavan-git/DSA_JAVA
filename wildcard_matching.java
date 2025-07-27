public class wildcard_matching {
    public static boolean tabulation(String s,String p,int n,int m){
        boolean dp[][]=new boolean[n+1][m+1];

        //initialization steps
        dp[0][0]=true; // empty string matches with empty pattern

        for(int i=1;i<=n;i++){
            dp[i][0]=false;
        }
        for(int j=1;j<=m;j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }else{
                dp[0][j]=false;    // where other characters like a,b,c ... or ? is there
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if((s.charAt(i-1)==p.charAt(j-1)) || p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-1] || dp[i-1][j];
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s = "aa", p = "a?";
        int n=s.length();int m=p.length();
        System.out.println(tabulation(s, p, n, m));
    }
}

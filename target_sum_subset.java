import java.util.*;;
public class target_sum_subset {
    public static boolean recursion(int arr[],int target,int n){
        if(n==0){return false;}
        if(target==0){return true;}
        if(arr[n-1]<=target){
            boolean include=recursion(arr, target-arr[n-1], n-1);
            boolean exclude=recursion(arr, target, n-1);
            return include || exclude;
        }else{
            return recursion(arr, target, n-1);
        }
    }
    public static boolean memoization(int arr[],int target,int n, int dp[][]){
        if(target==0){return true;}
        if(n==0){return false;}
        if(dp[n][target]!=-1){
            return dp[n][target]==1;
        }
        if(arr[n-1]<=target){
            boolean include=memoization(arr, target-arr[n-1], n-1, dp);
            boolean exclude=memoization(arr, target, n-1, dp);
            if(include || exclude){
                dp[n][target]=1;
            }else{
                dp[n][target]=0;
            }
            return dp[n][target]==1;
        }else{
            dp[n][target]= memoization(arr, target, n-1, dp)==true?1:0;
            return dp[n][target]==1;
        }
    }
    public static boolean tabulation(int arr[],int target,int n, int dp[][]){
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(arr[i-1]<=j){
                    //include or exclude
                    int inc=dp[i-1][j-arr[i-1]];
                    int exc=dp[i-1][j];
                    dp[i][j]=(inc==1 || exc==1)?1:0;
                }else{  
                    dp[i][j]=dp[i-1][j];                    
                }
            }
        }
        return dp[n][target]==1;

    }
    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int target = 9;
        //System.out.println(recursion(arr,target,arr.length));
        int n=arr.length;
        int dp[][]=new int[n+1][target+1];
        for(int i[]:dp){Arrays.fill(i,-1);}
        System.out.println(tabulation(arr, target, n, dp));
        for(int i[]:dp){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}

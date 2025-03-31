public class practice {
    public static void maxSubarray(int n[]) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int ni=0,nj=0;
        int prefixsum[]=new int[n.length];
        prefixsum[0]=n[0];
        for(int i=1;i<n.length;i++){
            prefixsum[i]=prefixsum[i-1]+n[i];
        }
        for(int i=0;i<n.length;i++){
            for(int j=i;j<n.length;j++){
                currentSum = 0;
                currentSum=i==0?prefixsum[j]:prefixsum[j]-prefixsum[i-1];
                if(maxSum<currentSum){
                    maxSum=currentSum;
                    ni=i;
                    nj=j;
                }
        }}
        System.out.println("The max sum is :"+maxSum);System.out.print("The max subarray is: ");
        for(int i=ni;i<=nj;i++){System.out.print(n[i]+" ");}
    }    
    public static void main(String[] args) {
        int array[] = {9,2,-10,4,8,20,-13,4};  
        maxSubarray(array);      
    }
}
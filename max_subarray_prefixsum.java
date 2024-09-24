public class max_subarray_prefixsum {
    public static void prefix_sum(int array[]){
        int prefix_sum[]=new int[array.length];
        prefix_sum[0]=array[0];
        for(int i=1;i<array.length;i++){
            prefix_sum[i]=prefix_sum[i-1]+array[i];
        }
        int max=Integer.MIN_VALUE;
        int ni=0;int nj=0;
        for(int i=0;i<array.length;i++){
            for(int j=i;j<array.length;j++){
                int count=0;
                count=i==0 ? prefix_sum[j] :prefix_sum[j]-prefix_sum[i-1];//prefix[end]-prefix[start-1]
                if(count>max)
                {
                    max=count;
                    ni=i;nj=j;
            }           
            }
        }
        System.out.println("The max sum is :"+max);System.out.print("The max subarray is: ");
        for(int i=ni;i<=nj;i++){System.out.print(array[i]+" ");}
    }
    public static void main(String[] args) {
        int array[]={23,45,1,6,-24,15,-6,-2,9,10,-3,3,2,-1,0};
        prefix_sum(array);
    }
}

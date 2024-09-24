public class max_subarray_brute_force {
    public static int update(int a,int b){
        int c=a;
        a=b;
        b=c;
        return a;
    }
    public static void max_sum(int array[]){
        int max=Integer.MIN_VALUE;
        int ni=0,nj=0;
        for(int i=0;i<array.length;i++){
            for(int j=i;j<array.length;j++){
                int count=0;
                for(int k=i;k<=j;k++){
                    count+=array[k];
                    if(count>max){
                        max=update(max,count);
                        ni=i;
                        nj=k;
                    }
                }
            }
        }
        System.out.println("The maximum sum is "+max);
        System.out.println("The max subarray is:");
        for(int i=ni;i<=nj;i++){System.out.print(array[i]+" ");}        
    }
    public static void main(String[] args) {
        int array[] = {9,2,-10,4,8,20,-13,4};
        max_sum(array);
    }
}

public class max_subarray_kadanes {
    public static void kadanes(int array[]){
        int max=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<array.length;i++){
            count+=array[i];
            if(count<0){count=0;}
            max=Math.max(max, count);
        }
        System.out.println("The max sum is: "+max);
    }
    public static void main(String[] args) {
        int array[]={23,45,1,6,-24,15,-6,-2,9,10,-3,3,2,-1,0};
        kadanes(array);
    }
}

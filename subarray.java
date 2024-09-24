public class subarray {
    public static void sub_array(int array[]){
        int t=0;
        for(int i=0;i<array.length;i++){
            
            for(int j=i;j<array.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(array[k]+" ");
                }
                t++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println(t);//no of subarrays
    }
    public static void main(String[] args) {
        int array[]={1,23,4,5,6,11,45};
        sub_array(array);
    }
}

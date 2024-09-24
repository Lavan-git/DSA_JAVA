public class diagnol_sum {
    public static int diagnol(int array[][]){
        int prim_sum=0;
        int sec_sum=0;
        
        for(int i=0;i<array.length;i++){
            prim_sum+=array[i][i];
            sec_sum+=array[i][array.length-1-i];
        }        
        if((array.length)%2==0){
            return prim_sum+sec_sum;
        }
        return prim_sum+sec_sum-array[(array.length+1)/2][(array.length+1)/2];
        }
    public static void main(String[] args) {
        int array[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int sum=diagnol(array);
        System.out.println("The sum of the diagnols is: "+sum);
    }
}

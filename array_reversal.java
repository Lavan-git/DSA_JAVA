public class array_reversal {
    public static void reverse(int array[]){
        for(int i=0;i<(array.length)/2;i++){
            int t=array[i];
            array[i]=array[array.length-i-1];
            array[array.length-i-1]=t;            
        }
        
    }
    public static void main(String[] args) {
        int array[]={1,4,5,2,7,3,19,11,54,10};
        reverse(array);
        for (int i=0;i<array.length;i++) {
            System.out.print(array[i]+" ");
        }
    }
}
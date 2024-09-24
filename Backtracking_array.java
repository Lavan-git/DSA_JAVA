public class Backtracking_array {
    public static void changearray(int array[],int i, int value){
        //base case
        if(i==array.length){
            printarr(array);
            return;
        }
        //recursion
        array[i]=value;
        changearray(array, i+1, value+1);
        array[i]-=2;//backtracking step
    }
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
    }
    System.out.println();
    }
    public static void main(String[] args) {
        int array[]=new int[5];
        changearray(array,0,1);
        printarr(array);
    }
}

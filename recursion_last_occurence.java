public class recursion_last_occurence {
    public static int last_occurence(int arr[],int key,int i){
        if(i==-1){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return last_occurence(arr, key, i-1);
    }
    public static void main(String[] args) {
        int arr[]={1,2,44,21,67,1,3,6,7,3,2,4,6,4};
        System.out.println(last_occurence(arr, 2, arr.length-1));
    }
}

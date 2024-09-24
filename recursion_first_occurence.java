public class recursion_first_occurence {
    public static int first_occurence(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return first_occurence(arr, key, i+1);
    }
    public static void main(String[] args) {
        int arr[]={1,2,44,21,67,1,3,6,7,3,2,4,6,4};
        System.out.println(first_occurence(arr, 4, 0));
    }
}

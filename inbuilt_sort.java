import java.util.*;
public class inbuilt_sort {
    public static void printArr(int array[]){
        for (int i : array) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        int arr[]={5,4,3,2,1};
        Arrays.sort(arr);
        printArr(arr);
    }
}

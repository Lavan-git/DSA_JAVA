import java.util.*;
public class sts_prac {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<Integer,Boolean> h=new HashMap<>();
        System.out.println("enter the number of elements");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
            if(h.containsKey(arr[i])){
                System.out.println("Duplicate found");
            }
            h.put(arr[i],true);
        }
    }
}

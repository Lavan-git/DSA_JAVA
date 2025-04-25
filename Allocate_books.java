import java.util.Arrays;

public class Allocate_books {
    public static int find_no_of_students(int arr[],int pages){
        int n = arr.length;
        int ans=1;
        int temp_sum=0;
        for(int i=0;i<n;i++){
            if(temp_sum+arr[i]<=pages){
                temp_sum+=arr[i];
            }else{
                ans++;
                temp_sum = arr[i];
            }
        }
        return ans;
    }
    public static int allocateBooks(int arr[],int students){
        int max=Arrays.stream(arr).max().getAsInt();
        int low=max;
        int high=Arrays.stream(arr).sum();
        while(low<=high){
            int mid = (low+high)/2;
            int no_of_students = find_no_of_students(arr,mid);
            if(no_of_students<=students){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;

    }
    public static void main(String[] args) {
        int arr[]={12,34,67,90};
        int students = 2;
        System.out.println(allocateBooks(arr,students));
    }
}

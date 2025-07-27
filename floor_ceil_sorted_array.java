public class floor_ceil_sorted_array {
    public static void main(String[] args) {
        int arr[] ={3, 4, 4, 7, 8, 10};
        int x=8;
        int floor=-1;
        int ceil=-1;
        int j=arr.length-1;
        int i=0;
        
        while(i<=j){
            int mid=i+(j-i)/2;
            if(arr[mid]>x){
                ceil=arr[mid];
                j=mid-1;
            }else if(arr[mid]<x){
                floor=arr[mid];
                i=mid+1;
            }else{
                ceil=arr[mid];
                floor=arr[mid];
                break;
            }
        }
        System.out.print(floor+" "+ceil);
    }
}

public class heapsort_2 {
    private static void heapify_max(int arr[],int i,int size){
        int left=2*i+1;
        int right=2*i+2;
        int maxidx=i;
        if(left<size && arr[left]>arr[maxidx]){
            maxidx=left;
        }
        if(right<size && arr[right]>arr[maxidx]){
            maxidx=right;
        }
        if(maxidx!=i){
            int temp=arr[maxidx];
            arr[maxidx]=arr[i];
            arr[i]=temp;
            heapify_max(arr,maxidx,size);
        }
    }
    private static void heapify_min(int arr[],int i,int size){
        int left=2*i+1;
        int right=2*i+2;
        int minidx=i;
        if(left<size && arr[left]<arr[minidx]){
            minidx=left;
        }
        if(right<size && arr[right]<arr[minidx]){
            minidx=right;
        }
        if(minidx!=i){
            int temp=arr[minidx];
            arr[minidx]=arr[i];
            arr[i]=temp;
            heapify_min(arr,minidx,size);
        }
    }
    public static void heap_sort_asc(int arr[]){
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapify_max(arr, i, n);
        }

        for(int i=n-1;i>=0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            heapify_max(arr, 0, i);
        }
        
    }
    public static void heap_sort_desc(int arr[]){
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapify_min(arr, i, n);
        }

        for(int i=n-1;i>=0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            heapify_min(arr, 0, i);
        }
        
    }
    public static void main(String[] args) {
        int arr[]={1,4,6,2,3};
        heap_sort_asc(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        heap_sort_desc(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

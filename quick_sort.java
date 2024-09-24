public class quick_sort {
    public static void printarr(int a[]){
        for(int i=0;i<a.length;i++){System.out.print(a[i]+" ");}
    }
    public static void qs(int arr[],int si,int ei){
        if(si>=ei){return;}
        //taking pivot as last element
        int pidx=partition(arr,si,ei);
        qs(arr, si, pidx-1);
        qs(arr,pidx+1,ei);
    }
    public static int partition(int arr[],int si,int ei){
        int pivot=arr[ei];
        int i=si-1;        
        for(int j=si;j<ei;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
        }
    public static void main(String[] args) {
        int arr[]={6,3,9,5,2,8};
        qs(arr,0,arr.length-1);
        printarr(arr);
    }
}

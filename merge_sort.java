public class merge_sort {
    public static void printarr(int a[]){
        for(int i=0;i<a.length;i++){System.out.print(a[i]+" ");}
    }
    public static void merge(int[] arr,int si,int mi,int ei){
        int temp[]=new int[ei-si+1];
        int i=si;//iterator for left part
        int j=mi+1;//iterator for right part
        int k=0;//iterator for the temp array
        while(i<=mi && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;                
            }
            else{
                temp[k]=arr[j];
                j++;                
            }
        k++;
        }
        //left part
        while(i<=mi){
            temp[k++]=arr[i++];
        }
            //right part
        while(j<=ei){
            temp[k++]=arr[j++];
        } 
        //now copy temp array to arr
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
        
    }
    public static void msort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mi=si+(ei-si)/2;
        msort(arr, si, mi);
        msort(arr, mi+1, ei);
        merge(arr,si,mi,ei);
    }
    public static void main(String[] args) {
        int arr[]={6,3,9,5,2,8};
        msort(arr, 0, arr.length-1);
        printarr(arr);
    }
}

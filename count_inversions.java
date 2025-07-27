public class count_inversions {
    static int count=0;
    public static void msort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mi=si+(ei-si)/2;
        msort(arr,si,mi);
        msort(arr,mi+1,ei);
        merge(arr,si,mi,ei);
    }
    public static void merge(int arr[],int si,int mi,int ei){
        int temp[]=new int[ei-si+1];
        int i=si;
        int j=mi+1;
        int k=0;
        while(i<=mi && j<=ei){
            if(arr[i]>arr[j]){
                count+=mi-i;
                temp[k++]=arr[j++];
            }else{
                temp[k++]=arr[i++];
            }
        }
        while(i<=mi){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }
    public static int inversionCount(int arr[]) {
        // Your Code Here
        msort(arr,0,arr.length-1);
        return count;        
    }
    public static void main(String[] args) {
        int arr[]={2,3,4,5,6};
        System.out.println(inversionCount(arr));

    }
}

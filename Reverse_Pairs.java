public class Reverse_Pairs {
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
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
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
    public static void main(String args[]) {
        // Your Code Here
        int arr[]={2,4,3,5,1};
        msort(arr,0,arr.length-1);
        System.out.print(count);
    }
}

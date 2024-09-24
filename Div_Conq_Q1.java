public class Div_Conq_Q1 {
    public static void printarr(String a[]){
        for(int i=0;i<a.length;i++){System.out.print(a[i]+" ");}
    }
    
    public static void merge(String arr[],int si,int mi,int ei){
        String[] temp=new String[ei-si+1];
        int i=si;
        int j=mi+1;
        int k=0;
        
        
        while(i<=mi && j<=ei){
            if(arr[i].compareTo(arr[j])<0){ // comparison of 2 strings using compare to
                temp[k]=arr[i];
                i++;                
            }
            else{
                temp[k]=arr[j];
                j++;                
            }
            k++;}
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
    public static void msort(String arr[],int si,int ei){
        if(si>=ei){return;}
        int mi=si+(ei-si)/2;
        msort(arr,si,mi);
        msort(arr,mi+1,ei);
        merge(arr, si, mi, ei);
    }
    public static void main(String[] args) {
        String arr[]={ "sun", "earth", "mars", "mercury"};
        msort(arr, 0, arr.length-1);
        printarr(arr);
    }
}

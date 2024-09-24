public class insertion_sort {
    public static void ins_s(int array[]){
        for(int i=1;i<array.length;i++){
            int curr=array[i];
            int prev=i-1;
            while (prev>=0 && curr<array[prev]) {
                array[prev+1]=array[prev];
                prev--;                
            }
            array[prev+1]=curr;            
        }
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
    public static void main(String[] args) {
        int array[]={5,4,3,2,1};
        ins_s(array);
    }
}

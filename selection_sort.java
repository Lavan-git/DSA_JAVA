public class selection_sort {
    public static void ss(int array[]){
        for(int i=0;i<array.length-1;i++){
            int minPos=i;
            for(int j=i+1;j<array.length;j++){
                if(array[minPos]>array[j]){
                    minPos=j;
                }
            }
            int t=array[i];
            array[i]=array[minPos];
            array[minPos]=t;
        }
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
    public static void main(String[] args) {
        int array[]={5,4,3,2,1};
        ss(array);
    }
}

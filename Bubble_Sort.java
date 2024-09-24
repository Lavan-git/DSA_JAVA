public class Bubble_Sort {
    public static void bubble(int array[]){
        for(int i=0;i<array.length-1;i++){
            int swap=0;
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int t=array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                    swap++;
                }
            }
            if(swap==0){break;}
            
        }
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
    public static void main(String[] args) {
        int array[]={5,4,3,2,1};
        bubble(array);
    }
}

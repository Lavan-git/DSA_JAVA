public class array_pair {
    public static void pair(int array[]){
        for(int i=0;i<array.length;i++){
            
            for(int j=i+1;j<array.length;j++){              
                System.out.println("("+array[i]+","+array[j]+")");
            }
        }
    }
    public static void main(String[] args) {
        int array[]={1,2,3,4,5,7,9,11,12,15,17,10,6,8};
        pair(array);
    }
}

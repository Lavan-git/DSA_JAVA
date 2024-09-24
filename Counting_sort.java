public class Counting_sort {
    public static void cs(int array[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            largest=Math.max(largest, array[i]);
        }
        int count[]=new int[largest+1];
        for(int i=0;i<array.length;i++){
            count[array[i]]++;
        }
        int var=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                array[var]=i;
                var++;
                count[i]--;
            }
        }
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
    public static void main(String[] args) {
        int array[]={2,3,4,1,1,1,2,3,6,3,2,2,3,5,6,9,2,1};
        cs(array);
    }
}

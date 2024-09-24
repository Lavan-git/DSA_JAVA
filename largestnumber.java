
public class largestnumber {
    public static int largest_number(int array[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(array[i]>largest){largest=array[i];}

        }
        return largest;
    }
    public static void main(String[] args) {
        int array[]={1,5,3,9,2,12,65,100,36,2,6,3,2,7,5,3,4,6,7,8,2,1,8,9,32,21,4,778,46};
        int largest=largest_number(array);
        System.out.println(largest);
    }
}



public class linear_search {
    public static int linearsearch(int array[],int key){
        for (int i=0;i<array.length;i++) {
            if(array[i]==key){
                System.out.println("The element "+key+" is found at index "+i);
                return 0;
                
            }           
        }
        return -1;
    }
    public static void main(String[] args) {
        int op=22;
        int array[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int a=linearsearch(array,op);
        if(a!=0)
            System.out.println(a);
    }
}

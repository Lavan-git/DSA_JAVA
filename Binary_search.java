public class Binary_search {
    public static int bin_search(int array[],int key){
        int start =0;        
        int stop=array.length-1;               
        while(start<=stop){
            int mid=(stop+start)/2;
            if(array[mid]>key){
                stop=mid-1;
            }else if(array[mid]==key)
            {return mid;}
            else{
                start=mid+1;
            }            
        }
        return -1;        
    }
    public static void main(String[] args) {
        int array[]={2,4,5,7,8,9,10,11,15,19,20,30,33,38,67,87,100,109};
        int search=69;
        int a=bin_search(array, search);
        if(a==-1){
            System.out.println("Element not found");
        }else{
            System.out.println("The element is found at index "+a);
        }
    }
}

import java.util.*;;
public class union_and_intersection_of_2_arrays {
    public static void main(String[] args) {
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        } 
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        } 
        System.out.println("The size of union of array is :"+set.size());
        System.out.println("The union array is:"+set);
        set.clear();
        HashSet<Integer> set2=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }        
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                set2.add(arr2[i]);
            }
        }
        System.out.println("The intersection of the array size is:"+set2.size()+" and the array is : "+set2);      
    }       
}

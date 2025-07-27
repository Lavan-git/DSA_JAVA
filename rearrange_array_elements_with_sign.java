import java.util.*;
public class rearrange_array_elements_with_sign {
    public static void main(String[] args) {
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
        int nums[]={3,1,-2,-5,2,-4};
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                pos.add(nums[i]);
            }else{
                neg.add(nums[i]);
            }
        }
        int k=0;
        int i=0;
        while(i<pos.size() && i<neg.size()){
            nums[k++]=pos.get(i);
            nums[k++]=neg.get(i);
            i++;
        }
        for(int j:nums){
            System.out.print(j+" ");
        }
        
    }
}

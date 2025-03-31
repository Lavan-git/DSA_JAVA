import java.util.*;

public class Arraylist_lonelynumbers {
    public static List<Integer>  findLonelyNumbers(int[] nums) {
        ArrayList<Integer>  res = new ArrayList<>();
        Arrays.sort(nums);
        if(Math.abs(nums[0]-nums[1])>1){
            res.add(nums[0]);
        }
        for(int i=1;i<nums.length-1;i++){
            if(Math.abs(nums[i]-nums[i+1])>1 && (Math.abs(nums[i]-nums[i-1])>1)){
                res.add(nums[i]);
            }
        }
        if(nums.length>=2){
            if(nums[nums.length-1]-nums[nums.length-2]>1){
                res.add(nums[nums.length-1]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int nums[]={10,6,5,8};
        System.out.println(findLonelyNumbers(nums));
    }
}

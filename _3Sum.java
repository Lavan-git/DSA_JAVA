import java.util.*;
public class _3Sum {
    public static void main(String[] args){
        int nums[]={-1,0,1,2,-1,-4};
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            int left=i+1;
            int right=n-1;
            if(i>0 && nums[i]==nums[i-1]) continue;
            while(left<right){
                int x=nums[i]+nums[left]+nums[right];
                if(x==0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right && nums[left]==nums[left+1])
                        left++;
                    while(left<right && nums[right]==nums[right-1])
                        right--;
                    left++;right--;
                }else if(x<0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        System.out.println(ans);
    }
}

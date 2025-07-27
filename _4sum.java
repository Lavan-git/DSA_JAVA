import java.util.*;

public class _4sum {
    public static void main(String[] args) {
        int nums[]={2,2,2,2,2};
        int target=8;
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]){continue;}
            for(int j=i+1;j<n-2;j++){  
                if(j>i+1 && nums[j]==nums[j-1]){continue;}              
                int left=j+1;
                int right=n-1;
                while(left<right){
                    long k=(long)(nums[i]+nums[j])+(long)(nums[left]+nums[right]);
                    //System.out.println(k);
                    if(k==target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left]==nums[left+1])
                            left++;
                        while(left<right && nums[right]==nums[right-1])
                            right--;
                        left++;
                        right--;
                    }else if(k<target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

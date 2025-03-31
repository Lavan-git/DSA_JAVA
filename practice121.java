import java.util.*;
public class practice121 {
    public static int storewater(ArrayList<Integer> height){
        int maxWater=0;
        int currWater=0;
        int h=0;int w=0;
        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                h=Math.min(height.get(i), height.get(j));
                w=j-i;
                currWater=h*w;
                maxWater=Math.max(currWater, maxWater);
            }
        }
        return maxWater;
    }
    public static int two_pointer_approach_storewater(ArrayList<Integer> height){
        int maxWater=0;
        int lp=0;
        int rp=height.size()-1;
        int currWater=0;
        while(lp<rp){
            currWater=Math.min(height.get(lp), height.get(rp))*(rp-lp);
            maxWater=Math.max(currWater, maxWater);
            if(height.get(lp)<height.get(rp)){
                lp++;
            }else
            {
                rp--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList <Integer> height = new ArrayList<>();
        //1,8,6,2,5,4,8,3,7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.print(two_pointer_approach_storewater(height));
    }
}

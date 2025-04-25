import java.util.Stack;

public class max_area_in_histogram {
    public static int maxArea(int[] height) {
        Stack<Integer> s1=new Stack<>();
        int right_small[]=new int[height.length];
        int left_small[]=new int[height.length];
        int max_area=0;
        for(int i=height.length-1;i>=0;i--){
            while(!s1.isEmpty() && height[i]<=height[s1.peek()]){
                s1.pop(); 
            }
            if(s1.isEmpty()){
                right_small[i]=height.length;
            }
            else{
                right_small[i]=s1.peek();
            }
            s1.push(i);
        }
        s1.clear();
        for(int i=0;i<height.length;i++){
            while(!s1.isEmpty() && height[i]<=height[s1.peek()]){
                s1.pop(); 
            }
            if(s1.isEmpty()){
                left_small[i]=-1;
            }
            else{
                left_small[i]=s1.peek();
            }
            s1.push(i);
        }
        for(int i=0;i<height.length;i++){
            System.out.println(height[i]*(right_small[i]-left_small[i]-1));
            max_area=Math.max(max_area,height[i]*(right_small[i]-left_small[i]-1));
        }
        return max_area;
    }
    public static void main(String[] args) {
        int height[]={2,1,5,6,2,3};
        System.out.println(maxArea(height));
    }
}

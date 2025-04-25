import java.util.Stack;

public class Next_greater_element_stack {
    public static int[] nextGreaterElement(int arr[]){
        Stack<Integer> s = new Stack<Integer>();
        int res[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.empty()){
                res[i]= -1;
            }else{
                res[i]=arr[s.peek()];
            }
            s.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int [] arr={6,8,0,1,3};
        int [] res=nextGreaterElement(arr);
        for(int i:res){
            System.out.print(i+" ");
        }

    }
}

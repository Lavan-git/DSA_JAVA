import java.util.*;
public class practice12 {
    public static void two_pointer_pair_sum(ArrayList<Integer> arr, int target) {
        int left = 0, right = arr.size() - 1;
        while (left < right) {
            int sum = arr.get(left) + arr.get(right);
            if (sum == target) {
                System.out.println("Pair found: (" + arr.get(left) + ", " + arr.get(right)+")");
                left++;
                right--;
            } 
            else if (sum < target) {
                left++;
            } else 
            {
                right--;
            }
        }
    }
    public static void two_pointer_pair_sum2(ArrayList<Integer> list2,int target){
        int left=0;int right=list2.size()-1;
        for(int i=0;i<list2.size()-1;i++){
            if(list2.get(i)>list2.get(i+1)){
                left=i+1;
                right=i;
                break;
            }
        }
        while(left!=right){
            int sum=list2.get(left)+list2.get(right);
            if(sum==target){
                System.out.println("Pair found: ("+list2.get(left)+", "+list2.get(right)+")");
                left=(left+1)%list2.size();
                right=(right-1+list2.size())%list2.size();
            }
            else if(sum<target){
                left=(left+1)%list2.size();
            }else{right=(right-1+list2.size())%list2.size();}
        }
    }
    public static void lonelynumbers(ArrayList<Integer> list){
        Collections.sort(list);
        if(Math.abs(list.get(0)-list.get(1))>1){
            System.out.print(list.get(0)+" ");
        }
        for(int i=1;i<list.size()-1;i++){
            if(Math.abs(list.get(i)-list.get(i-1))>1 && Math.abs(list.get(i)-list.get(i+1))>1){
                System.out.print(list.get(i)+" ");
            }
        }
        if(list.size()>=2){
            if(Math.abs(list.get(list.size()-1)-list.get(list.size()-2))>1){
                System.out.print(list.get(list.size()-1)+" ");
            }
        }
    }
    
    public static void main(String[] args) {
        // ArrayList<Integer> list=new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // list.add(6);
        // list.add(7);
        // list.add(8);
        // list.add(9);
        // two_pointer_pair_sum(list, 10);
        // ArrayList<Integer> list2=new ArrayList<>();
        // list2.add(11);
        // list2.add(15);
        // list2.add(6);
        // list2.add(8);
        // list2.add(9);
        // list2.add(10);
        // two_pointer_pair_sum2(list2, 16);
        ArrayList<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);
        lonelynumbers(list);
    }
}
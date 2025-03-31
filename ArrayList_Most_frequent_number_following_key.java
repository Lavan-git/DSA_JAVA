import java.util.*;
public class ArrayList_Most_frequent_number_following_key {
    public static int solution(ArrayList<Integer> list,int key){
        int arr[]=new int[1000];
        int max=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i)==key){
                arr[list.get(i+1)-1]++;
            }               
        }
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
                index=i;
            }
        }
        return index+1;
    }
    public static void main(String[] args){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(100);
        list.add(200);
        list.add(1);
        list.add(100);
        System.out.print(solution(list, 1));
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class Queue_First_nonrepeating_letter {
    public static void solution(String str){
        int[] count = new int[26];
        Queue <Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            q.add(str.charAt(i));
            count[str.charAt(i)-'a']++;
            while(!q.isEmpty() && count[q.peek()-'a'] > 1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print("-1 ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }

        
    }
    public static void main(String[] args) {
        solution("aabccxb");
    }
}


        


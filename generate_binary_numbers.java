import java.util.*;
public class generate_binary_numbers {
    public static void solution(int n){
        Queue<String> q=new LinkedList<>();
        q.add("1");
        while(n-->0){
            String temp=q.poll();
            q.add(temp+'0');
            q.add(temp+'1');
            System.out.print(temp+" ");
        }
    }
    public static void main(String[] args) {
        int n=9;
        solution(n);
    }
}

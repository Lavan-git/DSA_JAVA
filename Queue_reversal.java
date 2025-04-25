import java.util.*;
public class Queue_reversal {
    public static void reverse(Queue<Integer> q1){
        Stack<Integer> s=new Stack<>();
        while(!q1.isEmpty()){
            s.push(q1.poll());
        }
        while(!s.isEmpty()){
            q1.add(s.pop());
        }

    }
    public static void main(String[] args) {
        Queue<Integer> q1=new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        q1.add(6);
        q1.add(7);
        q1.add(8);
        q1.add(9);
        q1.add(10);
        System.out.println("Original Queue: "+q1);
        reverse(q1);
        System.out.println("Reversed Queue: "+q1);
    }
}

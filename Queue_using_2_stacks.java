import java.util.*;
public class Queue_using_2_stacks {
    static class Queue{
        static Stack<Integer> s1 = new Stack<Integer>();
        static Stack<Integer> s2 = new Stack<Integer>();
        public static boolean isEmpty(){
            return s1.isEmpty();
        }
        public static void add(int data){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.empty()){
                s1.push(s2.pop());
            }
        }
        public static int remove(){
            if(isEmpty()){
                return -1;
            }
            return s1.pop();
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return s1.peek();
        }
    }
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
        
    }
}

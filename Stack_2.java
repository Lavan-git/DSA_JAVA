import java.util.*;
public class Stack_2 {
    public static void push_at_bottom(Stack<Integer> s,int val){
        if(s.empty()){
            s.push(val);
            return;
        }
        int temp=s.pop();
        push_at_bottom(s,val);
        s.push(temp);

    }
    public static String reverseString(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            s.push(str.charAt(i));
        }
        String res="";
        while(!s.empty()){
            res=res+s.pop();
        }
        return res;
    }
    public static void reverseStack(Stack<Integer> s){
        if(s.empty()){
            return;
        }
        int top=s.pop();
        reverseStack(s);
        push_at_bottom(s, top);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();   
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        // System.out.println("Original Stack: "+s);
        // push_at_bottom(s, 10);
        // System.out.println("Stack after pushing 10 at bottom: "+s);
        System.out.println("Original Stack: "+s);
        reverseStack(s);
        System.out.println("Stack after reversing: "+s);


        System.out.print(reverseString("kallu kalia"));
        
    }
}

import java.util.Stack;

public class Stack_Valid_Paranthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else if(s.charAt(i)==')' && !stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            }else if(s.charAt(i)=='}' && !stack.isEmpty() && stack.peek()=='{'){
                stack.pop();
            }
            else if(s.charAt(i)==']' && !stack.isEmpty() && stack.peek()=='['){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "({})[()((][][]]]))]";
        System.out.println(isValid(s)); 
    }
}

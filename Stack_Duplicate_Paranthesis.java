import java.util.Stack;

public class Stack_Duplicate_Paranthesis {
    public static boolean duplicateParanthesis(String s) {
        Stack<Character> stack = new Stack<>();
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ')') {
                stack.push(ch);
            }else{
                count=0;
                while(!stack.isEmpty() && stack.peek()!=ch ){             
                    stack.pop();
                    count++;
                }
                if(count==0){
                    return true;
                }
            }
        }
            return false;
        }
                        
    public static void main(String[] args) {
        String s="((a+b))";
        System.out.println(duplicateParanthesis(s));
    }
}

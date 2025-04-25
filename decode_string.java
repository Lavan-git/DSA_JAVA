import java.util.Stack;

public class decode_string {
    
    public static String decodeString(String s){
        String sb="";
        Stack<Integer> numStack=new Stack<>();
        Stack<String> stringStack=new Stack<>();
        int n=0;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                n=n*10+(s.charAt(i)-'0');
            }else if(s.charAt(i)!=']'){
                numStack.push(n);
                n=0;
                sb="";
                stringStack.push(sb.toString());
            }else{
                int num=numStack.pop();
                while(!stringStack.isEmpty() && !stringStack.peek().equals('[')){
                    sb=stringStack.pop()+sb;
                }
                String temp=sb;
                for(int k=0;k<num;k++){
                    sb=sb+temp;
                }
                stringStack.push(sb);
                
            
            }
                
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String encoded = "3[a]2[bc]";
        System.out.println(decodeString(encoded)); // Output: "aaabcbc"
    }
}

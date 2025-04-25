import java.util.*;
public class Simplify_path {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for (String p : paths) {
            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else if (!p.equals("") && !p.equals(".")) {
                stack.push(p);
            }
        }
        String result = "/";
        for (String s : stack) {
            result += s + "/";
        }
        return result.substring(0,result.length()-1);
    }
    public static void main(String[] args) {
        String path = "/home/user/./Documents/.././Pictures";
        String simplifiedPath = simplifyPath(path);
    }
}

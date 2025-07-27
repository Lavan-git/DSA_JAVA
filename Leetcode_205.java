import java.util.*;
public class Leetcode_205 {
    public static boolean isIsomorphic(String s,String t){
        HashMap<Character,Character> h1=new HashMap<>();
        HashMap<Character,Character> h2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            char d=t.charAt(i);
            if(h1.containsKey(c)){
                if(h1.get(c)!=d){return false;}
            }else{
                h1.put(c,d);
            }
            if(h2.containsKey(d)){
                if(h2.get(d)!=c){
                    return false;
                }
            }else{
                h2.put(d,c);
            }
        }
        return true;
    }
    public static void main(String[] args) {

        String s="egg",t="add";
        System.out.println(isIsomorphic(s,t));
    }
}

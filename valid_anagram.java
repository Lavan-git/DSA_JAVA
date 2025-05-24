import java.util.*;
public class valid_anagram {
    public static boolean solution(String str1,String str2){
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<str1.length();i++){
            char ch=str1.charAt(i);
            hm.put(ch,hm.getOrDefault(ch, 0)+1);
        }
        for(int i=0;i<str2.length();i++){
            char ch=str2.charAt(i);
            if(hm.get(ch)!=null){
                hm.put(ch,hm.get(ch)-1);
            }else{
                return false;
            }
        }
        for(Character c:hm.keySet()){
            if(hm.get(c)!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str1="anagram";
        String str2="gramana";
        System.out.print(solution(str1, str2));

    }
}

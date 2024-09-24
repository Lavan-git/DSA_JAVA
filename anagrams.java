import java.util.*;

public class anagrams {
    public static boolean check_anagram(String str1, String str2){
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        char[] ch1=str1.toCharArray();
        char[] ch2=str2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the first string :");
            String st1=sc.next();
            System.out.println("Enter the second string :");
            String st2=sc.next();
            if(check_anagram(st1, st2)){
                System.out.println("The strings entered are anagrams.");
                
            }else{
                System.out.println("The strings entered are not anagrams.");
            }
        }
    }
}
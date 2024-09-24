import java.util.Scanner;

public class String_Palindrome {
    public static boolean palindrome(String str){
        int n=str.length();
        for(int i=0;i<n/2;i++){
            if(str.charAt(i)==str.charAt(n-i-1)){
                continue;
            }
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the string :");
            String str=sc.next();
            boolean x=palindrome(str);
            if(x){
                System.out.println("The string is a palindrome.");
            }else{System.out.println("The string is not a palindrome.");}
        }
    }
}

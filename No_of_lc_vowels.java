public class No_of_lc_vowels {
    public static void main(String[] args) {
        String str="abcdefwjfeuf";
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u'){
                count++;
            }
        }
        System.out.println("The string has "+count+" number of lower case vowels.");
    }
}

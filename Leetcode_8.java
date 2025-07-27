public class Leetcode_8 {
    public static int myAtoi(String s) {
        int ans=0;

        s=s.trim();
        if(s.length()==0){
            return 0;
        }
        int sign=1; // -1-> false   ,  1-> true
        char c=s.charAt(0);
        int i=0;
        if(c=='-'){ sign=-1;i++;}
        else if(c=='+' || Character.isDigit(c)) sign=1;
        else return ans;

        while(i<s.length()){
            char t=s.charAt(i);
            if(!Character.isDigit(t)) break;
            int digit=t-'0';
            if(ans>(Integer.MAX_VALUE-digit)/10){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            ans=ans*10+digit;
            i++;
            
        }
        return ans*sign;
    }
    public static void main(String[] args) {
        String s="-042";
        System.out.println(myAtoi(s));
    }
}

public class Backtracking_permutation {
    public static void findpermutation(String str,String ans){
        //base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        //kaam
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            findpermutation(str.substring(0, i)+str.substring(i+1), ans+curr);
        }
    }
    public static void main(String[] args) {
        String str="auf";
        findpermutation(str, "");
    }
}

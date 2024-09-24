public class Backtracking_Find_Subsets {
    public static void findsubsets(String str, String output,int i){
        //base case
        if(i==str.length()){
            System.out.println(output);
            return;
        }
        // Recursion
        //yes
        findsubsets(str, output+str.charAt(i), i+1);
        //no
        findsubsets(str, output, i+1);
    }
    public static void main(String[] args) {
        String str="abcd";
        findsubsets(str, "", 0);
    }
}

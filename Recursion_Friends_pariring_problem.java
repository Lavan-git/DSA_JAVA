public class Recursion_Friends_pariring_problem {
    public static int FPP(int n){
        if(n==1 || n==2){
            return n;
        }
        //single
        // int c1=FPP(n-1);
        // //couple/pair
        // int c2=FPP(n-2);
        // int total_ways=(n-1)*c2+c1;
        // return total_ways;
        return FPP(n-1)+(n-1)*FPP(n-2);
    }
    public static void main(String[] args) {
        System.out.println(FPP(3));
    }
}
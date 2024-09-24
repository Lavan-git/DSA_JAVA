public class Recursion_Tiling_Problem {
    public static int TP(int n){
        if(n==1 || n==0)
            return 1;

        //work
        //vertical
        int fnm1=TP(n-1);
        //horizontal
        int fnm2=TP(n-2);
        return fnm1+fnm2;
    }
    public static void main(String[] args) {
        System.out.println(TP(4));
    }
}
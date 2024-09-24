public class recursion_nth_fibonacci_number {
    public static int nthfibonnaci(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return nthfibonnaci(n-1)+nthfibonnaci(n-2);
    }
    public static void main(String[] args) {
        System.out.println(nthfibonnaci(5));
    }
}

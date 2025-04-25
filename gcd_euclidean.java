public class gcd_euclidean {
    public static int gcd(int a,int b){
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        int a = 48;
        int b = 18;
        int gcd = gcd(a, b);
        System.out.println(gcd);
    }
}

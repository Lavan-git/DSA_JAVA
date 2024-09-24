public class recursion_x_power_n {
    public static int power(int a,int n){
        if(n==0){
            return 1;
        }
        int half_power=power(a, n/2);
        half_power*=half_power;
        if(n%2==0){
            return half_power;
        }else{
            return a*half_power;
        }
    }
    public static void main(String[] args) {
        System.out.println(power(2, 10));

    }
}

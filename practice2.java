public class practice2 {
    static void printDecreasing(int n){
        if(n==1){
            System.out.println(1);
            return;
        }
        System.out.println(n);
        printDecreasing(n-1);
    }
    static void printIncreasing(int n){
        if(n==1){
            System.out.println(1);
            return;
        }
        printIncreasing(n-1);
        System.out.println(n);
        
    }
    static int x_power_n_opt(int x,int n){
        if(n==0){
            return 1;
        }
        int half_power=x_power_n_opt(x, n/2);
        half_power*=half_power;
        if(n%2==0){
            return half_power;
        }
        else return half_power*x;
    }
    public static void main(String[] args) {
        printIncreasing(5);
    }
}
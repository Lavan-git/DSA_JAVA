public class p24_q2 {
    public static void printNumString(int n){
        if(n==0){return;}
        if(n%10==0){
            System.out.println("Invalid num, last digit is 0.");
            System.exit(0);
        }
        String arr[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
        printNumString(n/10);
        System.out.print(arr[n%10]+" ");
    }
    public static void main(String[] args) {
        printNumString(3432);
    }
}

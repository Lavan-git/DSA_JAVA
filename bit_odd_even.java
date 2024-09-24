import java.util.*;
public class bit_odd_even {
    public static boolean check(int a){
        if((a & 1)==0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number :");
            if(check(sc.nextInt())){
                System.out.println("The number is even.");
            }else
            System.out.println("The number is odd.");
        }
    }
}

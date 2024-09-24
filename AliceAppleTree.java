import java.util.Scanner;

public class AliceAppleTree {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of apples:");
        int apples=sc.nextInt();
        int count=0;int sum=0;
        while(sum<apples){
            count++;
            sum+=12*count*count;
        }
        System.out.println(8*count);
        sc.close();
    }
}

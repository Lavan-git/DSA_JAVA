import java.util.Scanner;

public class Toggle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of doors:");
        int n=sc.nextInt();
        boolean x[]=new boolean[n+1];
        sc.close();
        
        for(int i=1;i<=n;i++){
            for(int j=i;j*i<=n;j++){
                if(x[j]){
                    x[j]=false;
                }else{x[j]=true;}
            }
        }
        int c=0;int o=0;
        for(int i=1;i<=n;i++){
            if(x[i]){
                c++;
            }else{o++;}
        }
        System.out.println("The number of open doors are :"+o);
        System.out.println("The number of closed doors are : "+c);
    }
}

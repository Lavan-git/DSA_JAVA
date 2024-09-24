public class hollow_rhombus {
    public static void hollow_rho(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            for(int k=0;k<n;k++){
                if(i==0 || i==n-1 || k==0 || k==n-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            
            System.out.println();
        }
    }
    public static void main(String[] args) {
        hollow_rho(5);
    }
}

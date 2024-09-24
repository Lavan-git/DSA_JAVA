public class Inv_and_rot_half_pyr_patt {
    public static void main(String[] args) {
        for(int i=1;i<=4;i++){
            for(int j=4;j>i;j--){
                System.out.print(" ");
            }
            for(int k=0;k<i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

public class Floyd_triangle {
    public static void main(String[] args) {
        int x=1;
        for(int i=1;i<6;i++){
            for(int j=0;j<i;j++){
                System.out.print(x++ + " ");
            }
            System.out.println();
        }
    }
}

public class practice {

    public static int gridways(int row,int col,int n,int m){
        if(row==n-1 && col==m-1){return 1;}
        if(row==n || col==m){return 0;}
        return gridways(row, col, n-1, m)+gridways(row, col, n, m-1);
    }
    
    public static void main(String[] args) {
        System.out.println(gridways(0,0,3,3));
        
    }
}
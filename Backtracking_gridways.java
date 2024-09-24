public class Backtracking_gridways {

    public static int gridways(int row,int col,int n,int m){
        if(row ==n-1 && col==m-1){//last cell condition
            return 1;
        }else if(row==n || col==m){return 0;}//boundary check condition
        return gridways(row+1, col, n, m)+gridways(row, col+1, n, m);
        
    }
    public static void main(String[] args) {
        
        System.out.println(gridways(0,0,3,3));
    }
}

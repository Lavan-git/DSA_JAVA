public class Backtracking_NQ_countways {
    public static boolean isSafe(char board[][],int row,int col){
        //vertical up
        for(int i=row;i>=0;i--){
            if(board[i][col]=='Q'){return false;}
        }

        //horizontal left
        for(int j=col;j>=0;j--){
            if(board[row][j]=='Q'){return false;}
        }
        //diagnol left up
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){return false;}
        }
        //diagnol right up
        for(int i=row,j=col;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){return false;}
        }
        return true;
    }
    static int count=0;
    public static void NQueens(char board[][],int row){
        if(row==board.length){
            
            count++;
            return;
        }
        for(int j=0;j<board.length;j++){
            if(isSafe(board, row, j)){
            board[row][j]='Q';
            NQueens(board, row+1);
            board[row][j]='X';
            }
        }
    }
    public static void print(char[][] board){
        System.out.println("------------------CHESS BOARD-----------------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }    
            System.out.println();        
        }
    }
    public static void main(String[] args) {
        int n=4;
        char board[][]=new char[n][n];
        //Initialisation
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='X';
            }           
        }
        NQueens(board, 0);
        System.out.println("The number of ways to solve N queens is : "+count);
    }
}

public class Backtracking_knights {
    public static boolean isSafe(int board[][],int x,int y){
        return (x>=0 && x<board.length && y>=0 && y<board.length && board[x][y]==-1);
    }
    public static void printSol(int board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean knights(int n){
        int xMove[] = {2,1, -1, -2, -2, -1,1,2};
        int yMove[] = {1,2,2,1, -1, -2, -2, -1};
        int board[][]=new int [n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=-1;
            }
        }
        board[0][0]=0;
        if(placeKnights(board, xMove, yMove, 0,0, 1)){
            printSol(board);
            return true;
        }else{
            System.out.println("No solution exists");
            return false;
        }
        

    }
    public static boolean placeKnights(int board[][],int xMove[],int yMove[],int x,int y,int move){
        int n=board.length;
        int newX,newY;
        if(move==n*n){
            return true;
        }
        for(int i=0;i<8;i++){
            newX=x+xMove[i];
            newY=y+yMove[i];
            if(isSafe(board, newX, newY)){
                board[newX][newY]=move;
                if(placeKnights(board, xMove, yMove, newX, newY, move+1)){
                    return true;
                }
                else{
                    board[newX][newY]=-1;
                }
            }
        }
        return false;
        
    }
    public static void main(String[] args) {
        knights(8);
    }
}

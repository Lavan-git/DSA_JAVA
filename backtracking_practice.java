import java.util.Scanner;
public class backtracking_practice {
    public static int gridways(int curr_row,int curr_col,int m,int n){
        if(curr_col==n-1 && curr_row==m-1){
            return 1;
        }else if(curr_col==n || curr_row==m){
            return 0;
        }
        return gridways(curr_row+1, curr_col, m, n)+gridways(curr_row, curr_col+1, m, n);
    }
    public static void findsubsets(String n,String output,int i){
        if(i==n.length()){
            System.out.println(output);
            return;
        }
        findsubsets(n,output,i+1);
        findsubsets(n, output+n.charAt(i), i+1);
    }
    public static void findpermutation(String input,String output){
        if(input.length()==0){
            System.out.println(output);
            return;
        }
        for(int i=0;i<input.length();i++){
            findpermutation(input.substring(0, i)+input.substring(i+1), output+input.charAt(i));
        }
    }
    public static boolean isSafe(char board[][],int row,int col){
        int n=board.length;
        // in same row left or not
        for(int i=col;i>=0;i--){
            if(board[row][i]=='Q'){
                return false;
            }
        }
        // in same col up or not
        for(int i=row;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //diagnol left up
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //diagnol right up
        for(int i=row,j=col;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void NQueens(char board[][],int row){
        int n=board.length;
        if(row==n){
            printBoard(board);
            System.out.println();
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(board, row, i)){
                board[row][i]='Q';
                //printBoard(board);
                NQueens(board, row+1);
                board[row][i]='-';
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // System.out.println("Enter the string to find subsets:");
        // String n=sc.next();
        // findpermutation(n,"");
        System.out.println("Enter the value of row and column:");
        int m=sc.nextInt();
        int n=sc.nextInt();
        // char board[][]=new char[n][n];
        // for(int i=0;i<board.length;i++){
        //     for(int j=0;j<board.length;j++){
        //         board[i][j]='-';
        //     }    
        // }
        // NQueens(board, 0);
        System.out.println(gridways(0,0 ,m, n));
        sc.close();
        
    }

}

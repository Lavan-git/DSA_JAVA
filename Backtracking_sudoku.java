public class Backtracking_sudoku {
    public static boolean isSafe(int sudoku[][],int row,int col,int num){
        //check for row
        for(int i=0;i<9;i++){
            if(sudoku[i][col]==num){
                return false;
            }
        }

        //check for column
        for(int j=0;j<9;j++){
            if(sudoku[row][j]==num){
                return false;
            }
        }

        //check for grid
    }

    public static boolean sudoku_solver(int sudoku[][],int row,int col){
        if(row==9){
            print(sudoku);
            return true;
        }
        for(int j=0;j<col;j++){
            if(sudoku[row][j]!=0){
                if(isSafe(sudoku[row][j])){

                }
            }
            
        }
    }
    public static void print(int sudoku[][]){
        for(int i=0;i<sudoku.length;i++){
            for(int j=0;j<sudoku[0].length;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int sudoku[][]={{0,0,8,0,0,0,0,0,0},
                        {4,9,0,1,5,7,0,0,2},
                        {0,0,3,0,0,4,1,9,0},
                        {1,8,5,0,6,0,0,2,0},
                        {0,0,0,0,2,0,0,6,0},
                        {9,6,0,4,0,5,3,0,0},
                        {0,3,0,0,7,2,0,0,4},
                        {0,4,9,0,3,0,0,5,7},
                        {8,2,7,0,0,9,0,1,3}};
        
    }
}

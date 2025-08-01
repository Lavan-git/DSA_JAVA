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
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudoku_solver(int sudoku[][],int row,int col){
        if(row==9){            
            return true;
        }
        int nextRow=row;int nextCol=col+1;
        if(col+1==9){
            nextRow+=1;
            nextCol=0;
        }
        if(sudoku[row][col]!=0){
            return sudoku_solver(sudoku, nextRow, nextCol);
        }
        for(int digit=1;digit<=9;digit++){
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col]=digit;
                if(sudoku_solver(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col]=0;

            }
        }
        return false;
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
        if(sudoku_solver(sudoku, 0, 0)){
            print(sudoku);
        }else{
            System.out.println("Solution does not exist.");
        }
    }
}

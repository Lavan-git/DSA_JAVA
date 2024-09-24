public class Search_sorted_matrix {
    public static boolean SSM(int array[][],int key){
        //OTHER WAY
        // int row=0;int col=array[0].length-1;
        // while (row<array.length && col>=0) {
        //     if(array[row][col]==key){
        //         System.out.println("The element is found at index ("+row+","+col+").");
        //         return true;
        //     }else if(array[row][col]>key){
        //         col--;
        //     }else{row++;}            
        // }
        // System.out.println("Error 404, element not found :-(");
        // return false;
        int row=array.length-1;int col=0;
        while(row>=0 && col<array.length){
            if(array[row][col]==key){
                System.out.println("The element is found at index ("+row+","+col+").");
                return true;
            }else if(array[row][col]>key){
                    row--;
            }else{col++;}
        }
        System.out.println("Error 404, element not found :-(");
        return false;
    }
    public static void main(String[] args) {
        int array[][]={{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        SSM(array, 19);
    }
}

public class Spiral_matrix {
    public static void spiral(int array[][]){
        int startrow=0;int startcolumn=0;
        int endrow=array.length-1;int endcolumn=array[0].length-1;
        int count=0;
        while(count<(array.length)*(array[0].length)){
            for(int j=startcolumn;j<=endcolumn;j++){
                if(count==(array.length)*(array[0].length)){break;}
                System.out.print(array[startrow][j]+" ");
                count++;
            }
            for(int i=startrow+1;i<=endrow;i++){
                if(count==(array.length)*(array[0].length)){break;}
                System.out.print(array[i][endcolumn]+" ");
                count++;
            }
            for(int j=endcolumn-1;j>=startcolumn;j--){
                if(count==(array.length)*(array[0].length)){break;}
                System.out.print(array[endrow][j]+" ");
                count++;
            }
            for(int i=endrow-1;i>=startrow+1;i--){
                if(count==(array.length)*(array[0].length)){break;}
                System.out.print(array[i][startcolumn]+" ");
                count++;
            }
            startrow++;
            startcolumn++;
            endcolumn--;
            endrow--;
        }
    }
    public static void main(String[] args) {
        int array[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiral(array);
    }
}

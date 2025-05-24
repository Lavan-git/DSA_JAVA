import java.util.*;
public class Weakest_soldier {
    static class Row implements Comparable<Row>{
        int soldiers;
        int index;
        public Row(int soldiers,int index){
            this.soldiers=soldiers;
            this.index=index;
        }
        @Override
        public int compareTo(Row r2){
            if(r2.soldiers!=this.soldiers){
                return this.soldiers-r2.soldiers;
            }else{
                return this.index-r2.index;
            }
        }
    }
    public static void main(String[] args) {
        int army[][]={{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        PriorityQueue<Row> pq=new PriorityQueue<>();
        for(int i=0;i<army.length;i++){
            int temp=0;
            for(int j=0;j<army[0].length;j++){
                if(army[i][j]==1){temp++;}
            }
            pq.add(new Row(temp,i));
        }
        int k=2;
        for(int i=0;i<k;i++){
            System.out.println(pq.remove().index);
        }
    }
}

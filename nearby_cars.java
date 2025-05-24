import java.util.*;
public class nearby_cars {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        float dist;
        Point(int x,int y,float dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
        @Override
        public int compareTo(Point P2){
            return Float.compare(this.dist,P2.dist);
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Point> pq=new PriorityQueue<>();
        int arr[][]={{3,3},{5,-1},{-2,4}};
        int k=2;
        for(int i=0;i<arr.length;i++){
            pq.add(new Point(arr[i][0],arr[i][1],(float)Math.sqrt(Math.pow(arr[i][0],2)+Math.pow(arr[i][1],2))));
        }
        for(int i=0;i<k;i++){
            System.out.print("The point is : ("+pq.peek().x+","+pq.peek().y+")\n");

            pq.remove();
        }

    }
}

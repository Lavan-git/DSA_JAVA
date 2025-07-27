import java.util.ArrayList;

public class Graphs_1 {
    static class Edge{
        int src,wt,dest;
        public Edge(int src,int wt,int dest){
            this.src=src;
            this.wt=wt;
            this.dest=dest;
        }
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[] graph=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        graph[3].add(new Edge(3,2,1));
        graph[3].add(new Edge(3,1,3));

        graph[4].add(new Edge(4,2,2));
    }
}

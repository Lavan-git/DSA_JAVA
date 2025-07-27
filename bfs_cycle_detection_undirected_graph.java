import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs_cycle_detection_undirected_graph {
    static class Edge{
        int src,dest,wt;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.wt=wt;
            this.dest=dest;
        }
    }
    static class Pair{
        int node,par;
        public Pair(int node,int par){
            this.node=node;
            this.par=par;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){graph[i]=new ArrayList<Edge>();}

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }
    public static boolean detectCycle(ArrayList<Edge> graph[]){
        boolean visited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(bfsCycleDetection(graph,i,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean bfsCycleDetection(ArrayList<Edge>[] graph, int start,boolean[] visited) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(start,-1));
        while(!q.isEmpty()){
            Pair p=q.remove();
            int node=p.node;
            int par=p.par;
            for(int i=0;i<graph[node].size();i++){
                Edge e=graph[node].get(i);
                if(!visited[e.dest]){
                    visited[e.dest]=true;
                    q.add(new Pair(e.dest,node));
                }else if(e.dest!=par){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }
}

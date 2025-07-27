import java.util.*;

public class cycle_detection_directed_graph {
    static class Edge{
        int src,dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,3));

        //graph[3].add(new Edge(3, 1));  // creates cycle: 1 → 3 → 1

    }
    public static boolean isCycle(ArrayList<Edge> graph[]){  //USING DFS MODIFIED
        boolean visited[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i] && isCycleUtil(graph,i,visited,stack)){
                return true;
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge> graph[],int curr,boolean visited[],boolean stack[]){
        visited[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visited[e.dest] && isCycleUtil(graph, e.dest, visited, stack)){
                return true;
            }
            if(stack[e.dest]){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        System.out.print(isCycle(graph));
    }
}

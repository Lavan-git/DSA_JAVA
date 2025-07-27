import java.util.*;

public class Topological_sorting_DFS {
    static class Edge{
        int src,dest;
        public Edge(int src,int dest){this.src=src;this.dest=dest;}
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }
    public static ArrayList<Integer> topoSort(ArrayList<Edge> graph[]){
        boolean visited[]=new boolean[graph.length];
        Stack<Integer> stk=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                topoSortUtil(graph,i,visited,stk);
            }
        }
        while(!stk.empty()){
            ans.add(stk.pop());
        }
        return ans;
    }
    public static void topoSortUtil(ArrayList<Edge> graph[],int curr,boolean visited[],Stack<Integer> stk){
        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visited[e.dest]){
                topoSortUtil(graph, e.dest, visited, stk);
            }
        }stk.add(curr);
    }
    public static void main(String[] args) {
        int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        System.out.print(topoSort(graph));
    }
}

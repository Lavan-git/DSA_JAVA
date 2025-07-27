import java.util.*;
public class BFS {
    static class Edge{
        int src,wt,dest;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.wt=wt;
            this.dest=dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));
    }
    public static void bfs(ArrayList<Edge>[] graph){
        boolean visited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                bfsUtil(graph, visited);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge>[] graph,boolean visited[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!visited[curr]){
                System.out.print(curr+" ");
                visited[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge>[] graph){
        boolean visited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                dfsUtil(graph,i, visited);
            }
        }
    }
    public static void dfsUtil(ArrayList<Edge>[] graph,int curr,boolean visited[]){
        System.out.print(curr+" ");
        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            if(!visited[graph[curr].get(i).dest]){
                dfsUtil(graph,graph[curr].get(i).dest,visited);
            }
        }
    }
    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean visited[]){
        if(src==dest){
            return true;
        }
        visited[src]=true;
        for(int i=0;i<graph[src].size();i++){
            if(!visited[graph[src].get(i).dest] && hasPath(graph,graph[src].get(i).dest,dest,visited)){
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V=7;
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph);
        //dfs(graph,0,new boolean[graph.length]);
        System.out.print(hasPath(graph, 0, 5, new boolean[graph.length]));
    }
}

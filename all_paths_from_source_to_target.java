import java.util.ArrayList;

public class all_paths_from_source_to_target {
    static class Edge{
        int src,dest;
        public Edge(int src,int dest){this.src=src;this.dest=dest;}
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,3));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }
    public static void printAllPath(ArrayList<Edge> graph[],int src,int dest,String path){
        if(src==dest){
            System.out.println(path+dest);
        }
        for(int i=0;i<graph[src].size();i++){
            printAllPath(graph, graph[src].get(i).dest, dest, path+src);
        }
    }
    public static void main(String[] args) {
        int V=6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        printAllPath(graph, 5, 1, "");
    }
}

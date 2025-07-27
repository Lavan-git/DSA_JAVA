import java.util.*;

public class Kahns_algorithm {
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
    public static void calcIndegree(ArrayList<Edge> graph[],int indegree[]){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                indegree[graph[i].get(j).dest]++;
            }
        }
    }
    public static ArrayList<Integer> topSort(ArrayList<Edge> graph[]){
        ArrayList<Integer> ans=new ArrayList<>();
        int indegree[]=new int[graph.length];
        calcIndegree(graph, indegree);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            ans.add(curr);
            for(int i=0;i<graph[curr].size();i++){
                indegree[graph[curr].get(i).dest]--;
                if(indegree[graph[curr].get(i).dest]==0){
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        System.out.println(topSort(graph));
    }
}

package Graph;
import java.util.*;

public class G11_KosarajuAlgoScc {
    static class Edge{
        int src;
        int dest;

        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> [] graph){
        // make null to empty arraylist
        for(int i = 0 ; i< graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        // making uni-directed graph
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));

    }

    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> st){
        vis[curr] = true;

        for(int j =0 ; j<graph[curr].size();j++){
            Edge e = graph[curr].get(j);
            if(!vis[e.dest]){
                topSort(graph,e.dest,vis,st);
            }
        }
        st.push(curr);
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean [] vis){
        vis[curr] = true;
        System.out.print(curr+" ");

        for(int j =0 ; j<graph[curr].size();j++){
            Edge e = graph[curr].get(j);
            if(!vis[e.dest]){
                dfs(graph,e.dest,vis);
            }
        }
    }

    public static void kosaRajuAlgo( ArrayList<Edge>[] graph, int V){
        // Step  1 : topo sort  : O(V+E)
        Stack<Integer> st = new Stack<>();
        boolean [] vis = new boolean[V];
        for (int i = 0; i<V; i++){
            if(!vis[i]){
                topSort(graph, i, vis, st);
            }
        }

        // step 2 :  O(V+E) : transpose : make a clone graph where we will store edges in reverse order
        ArrayList<Edge>[] transpose = new ArrayList[V];
        for(int i = 0 ; i< graph.length;i++){
            vis[i] = false ; // so that we can use again in stepp 3;
            transpose[i] = new ArrayList<>();
        }
        // now go on each edge and store reverse
        for(int i = 0; i<graph.length;i++){
            for(int j = 0 ; j<graph[i].size();j++){
                Edge e = graph[i].get(j);  // here we are on a particular edge whose dest and src , we have access
                // e.src -> e.dest ==> transpose ==>e.dest->e.src
                transpose[e.dest].add(new Edge(e.dest,e.src));  // in  transpose we make a new edge where we store at e.dest point a  new edge  e.dest -> e.src
            }
        }

        // step 3:  O(V+E) : perform dfs on transpose graph using the stack of topsort
        while(!st.isEmpty()){
            int curr = st.pop();
            if(!vis[curr]){
                dfs(transpose,curr,vis);
                System.out.println();
            }

        }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        kosaRajuAlgo(graph, V);
    }

}

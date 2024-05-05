package Graph;
import java.util.*;
/*
this is legitiable for directed graph
as we can surely get a path for the given src and target in undirected
but in direted , we hv to check if path exist or not

we are going to solve this question using dfs

 */

public class G07_AllPathFrmSrcToTrget {
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
        graph[0].add(new Edge(0,3));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));

    }

    // T.C = exponention for worst case O(V^v)
    public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, String path){
        if(src == dest){
            System.out.println(path+dest);
            return;
        }

        for (int i = 0 ; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest,dest, path+src);
        }
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph);

        int src = 5,dest =1;
        printAllPath(graph,src,dest,"");
    }
}

package Graph;
import java.util.*;
/*
this is a dynamic programming not greedy approach and hv greatr tc
dijkstra fail in some cases:
    when the graph has negative edges;
    if the gtraph has negative cycle then the graph goes for TLE i.e. it  keeps on running and minimising the distance

    so BF Algo helps us to only detect negative cycle as well  but not applicable in negative cycle
    it is applicable only in directed graph

    if v = n
    -> relax all the edges n-1 times sequentially
    -> relax?
        if(dist[u]+wt <dist[v]){
                        dist[v] = dist[u]+wt;
                   it has same algo as dijkstra's but we have to do same comparison n-1 times

    fisrt make array where all other vertex have infinity
    why n-1?
    -> as edges can be be given in any order , so if the order is worst case i.e first v is the v that is to be visited last then we can say in n- 1 times we will able to update every node
        so taking that consideration we are doing it n-1 times
        or.
        we will take n01 edges to reach from the first to last , thereby we irterate for n-1 iteration

    how to detect negative cycles?
    -> on nth iteration , the relaxation will be done, and if the dist[] arr gets reduced , we can say (-ve) cycle exists

 */
public class G09_BellmanFordAlgo {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> [] graph){
        // make null to empty arraylist
        for(int i = 0 ; i< graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        // making uni-directed graph
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1));

    }

    public static void bellman_ford(ArrayList<Edge>[] graph,int src, int V){
        int[] dist = new int [V];  // dist[i]
        for(int i = 0 ; i<V; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;   // +infinity
            }
        }
        dist[src] = 0;

        for(int k = 0 ; k<V-1; k++){   // for n-1 iteration   // tc = k
            // for finding edge we do two loop , but tc = O(E)
            for(int i = 0; i<graph.length;i++){
                for(int j =0 ; j<graph[i].size();j++){
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] != Integer.MAX_VALUE && dist[u]+wt <dist[v]){   //// dist[u] != Integer.MAX_VALUE why we do so , bcoz in java if we add wt to dist[u] i.e. dist[u]+wt  where dist[u] is infinity  then we get negative not infinity so we give this condition
                        dist[v] = dist[u]+wt;   // update dist of src -> v
                    }
                }
            }
        }


        // Nth relaxation to check negative cycle
        for(int i = 0; i<V;i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    System.out.println("Negative wt. cycle");
                }
            }
        }

        //        print all source to vertices shortest dist
        for(int i = 0  ;i<dist.length; i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph);

        bellman_ford(graph,0,V);
    }
}

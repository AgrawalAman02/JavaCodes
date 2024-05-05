package Graph;
import java.util.*;
/*
Dijkstra's Algorithm :
Shortest paths from the source to all the vertices(weighted graph)

Time Comp :- O( V + E log(V))  if we use PQ
else O(v^2)
 */

public class G08_DijkstraAlgo {
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

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path){
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path;  // path based sorting for my pairs
        }
    }

    public static void dijksta(ArrayList<Edge>[] graph, int src){
        int[] dist = new int [graph.length];  // dist[i]
        for(int i = 0 ; i<graph.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;   // +infinity
            }
        }

        boolean [] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));  // first add 0 ->0
        //loop
        while(!pq.isEmpty()){
            Pair curr = pq.remove();  // curr->visit
            if(!vis[curr.n]){   // if curr->neighbours not vis then make then visit
                vis[curr.n] = true;

                // neighbours
                for(int i = 0 ; i<graph[curr.n].size();i++){
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u]+wt <dist[v]){
                        dist[v] = dist[u]+wt;   // update dist of src -> v
                        pq.add(new Pair(v,dist[v]));
                    }
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
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int src = 0;
        dijksta(graph,0);
    }

}

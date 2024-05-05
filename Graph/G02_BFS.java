package Graph;

import java.util.*;

/*
since in trees there is a root , so traversal start from there
but in graph htre is no specified startiung point , so we can take any vertex/src as starting point

 Bfs = Go to immediate neighbours first
 like level order traversal
 */
public class G02_BFS {
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

        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

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

    public static void bfs(ArrayList<Edge> [] graph){  // t.c. = O(V+E) as we are adding the vertics and edges (many times)
                                                            // so among V and E which one is greater dominates the T.C
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);  // source = 0

        while (!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){ // visit curr
                System.out.println(curr);
                vis[curr]  = true;
                for(int i = 0; i<graph[curr].size();i++){  // add all the neighbours of curr
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }

        }
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> [] graph = new ArrayList[v];
        createGraph(graph);
        bfs(graph);

    }
}

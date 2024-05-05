package Graph;
import java.util.*;

public class G06_TopoSortBFS {
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
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));

    }

    public static void calcIndeg(ArrayList<Edge>[] graph, int[] indeg){
        for(int i = 0 ; i< graph.length;i++){

            for(int j = 0 ; j<graph[i].size();j++){
                int dest = graph[i].get(j).dest;
                indeg[dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph){
        int [] indeg = new int[graph.length];
        calcIndeg(graph,indeg);
        Queue<Integer> q = new LinkedList<>();

        // store elements in q whose indeg == 0
        for(int i =0 ; i<indeg.length; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        //bfs
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");  // topological sort print

            for(int i = 0 ; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }


        }
        System.out.println();
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph);

        topSort(graph);

    }

}

// for practice solve leetcode question : 210. Course Schedule II

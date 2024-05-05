package Graph;
import java.util.*;

public class G05_TopoSortDFS {
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
    static Stack<Integer> st = new Stack<>();

    public static void createGraph(ArrayList<Edge> [] graph){
        // make null to empty arraylist
        for(int i = 0 ; i< graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        // making uni-directed graph
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,3,1));

        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,5,1));

    }

    public static void topSort(ArrayList<Edge>[] graph, int curr,boolean[] vis){    // t.c. = O(V+E)
        // visit
        System.out.println(curr);
        vis[curr] = true;

        for(int i = 0 ;i< graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]){
                topSort(graph,e.dest,vis);
            }
        }
        // After visiting all neighbors, push the current vertex onto the stack
        st.push(curr);

    }

    public static void main(String[] args) {
        ArrayList<Edge> [] graph = new ArrayList[6];
        createGraph(graph);

        topSort(graph,0,new boolean[6]);
        System.out.println("the topo sort  is ");

        while (st.size()!=0){
            System.out.println(st.peek());
            st.pop();
        }
    }
}

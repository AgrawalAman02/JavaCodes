package Graph;
import java.util.*;

public class G01_Creation {
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
    public static void main(String[] args) {
        int v = 5; // vertices
        // first we have to know the no. of vertices bcoz the array to be created is of the size of no. of vertices

        // we create arr as below
//        int [] arr = new int[v];
//        but the array we r making is not of int type but of arraylist<Edge> type so we do as below

        ArrayList<Edge> [] graph = new ArrayList[v];   // this grph is of ArrayList<Edge> type of size v
        // now in all the index of arr there is null means nothing but we should have empty arrayList there so we store there by a loop

        for (int i = 0 ; i<graph.length/* or V */;i++){
            graph[i] = new ArrayList<>();     // null -> empty arraylist
        }
        // now we store edges of each vertes on each index of the graph

        // 0- Vertex
        graph[0].add(new Edge(0,1,5));

        // 1- Vertex
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        // 2- Vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        //3 - vertex
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        // 4- Vertex
        graph[4].add(new Edge(4,2,2 ));

        // 2's neighbour
        // now we want to print all the neighbours of the 2 . How can we do ?
        // we will start a loop of size not of graph but of graph[2].size() . why to waste time to traverse all graph , we can traverse on the arrarlist of 2 index of graph

        for(int i = 0 ; i<graph[2].size();i++){
            Edge e = graph[2].get(i); // we get the i index edge of arraylist then we print its dest
            System.out.println(e.dest);
        }

    }
}

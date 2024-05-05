package BackTracking;

public class MazePath4direction {
    public static void main(String[] args) {
        int rows = 3 ;
        int cols = 3;
        boolean[][] arr = new boolean[rows][cols];
        int count= maze(0,0,rows-1,cols-1,"",arr);
        System.out.println(count);

    }

    private static int maze(int sr, int sc, int er, int ec, String ans, boolean[][] isVisited) {
        if(sr<0|| sc<0) return 0;
        if(sr>er || sc > ec) return 0;
        if(isVisited[sr][sc]==true) return 0;
        if(sc== ec && sr== er) {
            System.out.println(ans);
            return 1;
        }
        isVisited[sr][sc]=true;
        int downWays =maze(sr+1,sc,er,ec,ans+"D",isVisited);
        int rightWays = maze(sr,sc+1, er,ec, ans+"R",isVisited);
        int upWays = maze(sr-1,sc,er,ec,ans+"U",isVisited);
        int leftWays = maze(sr,sc-1,er,ec,ans+"L",isVisited);
        int totalWays = downWays+rightWays + upWays+ leftWays;
        //backtracking
        isVisited[sr][sc]= false;

        return totalWays;
    }
}

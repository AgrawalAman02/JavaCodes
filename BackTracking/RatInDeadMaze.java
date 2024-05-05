package BackTracking;

public class RatInDeadMaze {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 6;
        int[][] maze = {{1,0,1,1,1,1},
                        {1,1,1,1,0,1},
                        {0,1,1,1,1,1},
                        {0,0,1,0,1,1}};
        int count= maze(0,0,rows-1,cols-1,"",maze);
        System.out.println(count);
    }

    private static int maze(int sr, int sc, int er, int ec, String ans,int[][] maze) {
        if(sr>er || sc > ec) return 0;
        if(sc== ec && sr== er) {
            System.out.println(ans);
            return 1;
        }
        if(maze[sr][sc]==0) return 0;
        int downWays =maze(sr+1,sc,er,ec,ans+"D",maze);
        int rightWays = maze(sr,sc+1, er,ec, ans+"R",maze);
        int totalWays = downWays+rightWays;

        return totalWays;
    }
}
// can do the same thing in 4 direction adding isvisited boolean
// or we csn optimised it without using extra array by adding checkmark that if visited then -1
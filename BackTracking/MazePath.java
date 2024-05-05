package BackTracking;

public class MazePath {
    public static void main(String[] args) {
        int rows = 3 ;
        int cols = 3;
        int count= maze(1,1,rows,cols,"");
        System.out.println(count);
    }

    private static int maze(int sr, int sc, int er, int ec, String ans) {
        if(sr>er || sc > ec) return 0;
        if(sc== ec && sr== er) {
            System.out.println(ans);
            return 1;
        }
        int downWays =maze(sr+1,sc,er,ec,ans+"D");
        int rightWays = maze(sr,sc+1, er,ec, ans+"R");
        int totalWays = downWays+rightWays;

        return totalWays;
    }
}

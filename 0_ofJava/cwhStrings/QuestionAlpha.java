//Given a route containing 4 directions (E,W,N,S), find the shortest path to reach the destination
//  "WNEENESENNN"  W- WEST, N- NORTH , E- EAST, S- SOUTH;
package cwhStrings;

public class QuestionAlpha {
    public static float ShortestPath(String path){
        int x=0,y=0;
        for(int i=0;i<path.length();i++){
            char dir= path.charAt(i);
            if(dir=='N'){
                y++;
            }
            if(dir=='S'){
                y--;
            }
            if(dir=='E'){
                x++;
            }
            if(dir=='W'){
                x--;
            }
        }
        int X2 = x*x;
        int Y2= y*y;
        return (float)Math.sqrt(X2+Y2);
    }
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println("The shortest path is "+ ShortestPath(path));
    }
}

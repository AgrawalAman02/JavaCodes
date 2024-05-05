package Recursion;

public class Tilling {
    public static void main(String[] args) {
        System.out.println(tileWay(6));
    }
    static int tileWay(int n){  // 2*n(floor size)
        // base case
        if(n==0||n==1){
            return 1;

        }
        //kaam
        //vertical choice
        int fnm1 = tileWay(n-1);
        // horizantal choice
        int fnm2 = tileWay(n-2);
        int totWays = fnm2+fnm1;
        return totWays;
    }
}

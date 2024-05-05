package Recursion;

public class XpowerNoptimised {
    public static void main(String[] args) {
        System.out.println(OptimisedPower(2,5));
    }
    static int OptimisedPower(int a,int n){
        if(n==0){
            return 1;
        }
        int halfPower = OptimisedPower(a,n/2);
        int halfPowerSq= halfPower*halfPower;
        // n is odd
        if(n%2!= 0){
            halfPowerSq = a*halfPowerSq;
        }
        return halfPowerSq;
    }
}

// time complexity O(log(base 2)n);

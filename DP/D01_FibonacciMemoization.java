package DP;

public class D01_FibonacciMemoization {
    public static int fibo(int n , int [] f){
        if(n==0 || n== 1) return n;
        if(f[n]!=0){     // fib[n] is already calculated means for that value fwe dont calculate fib and return that value and if fib = 0 then we go for recurrence relation for calculation
            return f[n];
        }
        f[n] = fibo(n-1,f) + fibo(n-2,f);
        return f[n];
    }
    public static void main(String[] args) {
        int n = 6;
        int [] f = new int[n+1];   // initially by default all the place are 0
        // why n+1? --> because we calculate fibonacci for 0 to n so fib of 5 has fib(o) - fib (5)

        // by making extra f array to check if that call happened already or not, reduces the time complexity to a great extent
        // this process is called memoization : where we store small problem in a memory or a array
        // this is the one of the way of implementing Dp
        // so the f array we had made we can name it dp[]  

//        i.e now the time complexity becomes O(n) i.e. linear from exponential O(2^n)
        System.out.println(fibo(n,f));
    }
}

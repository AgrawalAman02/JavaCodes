package Methods_Practice_Question;

import java.util.Scanner;

public class Function_Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = Math.abs(a);  // gives the absolute / positive value
        int e= Math.max(a,b);
        int f= Math.min(b,c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);

    }
}

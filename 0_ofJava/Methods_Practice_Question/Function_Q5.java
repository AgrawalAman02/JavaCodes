

package Methods_Practice_Question;

import java.util.Scanner;

public class Function_Q5 {
    public static void main(String[] args) {
        System.out.print("enter the number to add its digit : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       int sum = Sum_digits(n);
        System.out.println("the sum of digits is "+ sum);

    }
    public static int Sum_digits(int n){
        int sum =0;
        while(n>0){
            int rem = n%10;
            sum = sum + rem;
            n=n/10;

        }
        return sum;
    }
}

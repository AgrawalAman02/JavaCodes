package conditionalStatement;

import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your age:  --  \t");
        int age=sc.nextInt();
        if (age>18){
            System.out.println("you r eligible to vote:)👍");
        } else if (age==18) {
            System.out.println("u  cAN also vote");
            
        } else {
            System.out.println("u r not eligible to vote:(");
        }
    }
}

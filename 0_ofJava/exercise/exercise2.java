package exercise;

import java.util.Random;
import java.util.Scanner;

public class exercise2 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int a = rnd.nextInt(2);
        String CTurn ;

        if(a==0){
           CTurn = "stone";
        } else if (a==1) {
            CTurn = "paper";

        }
        else{
            CTurn= "scissor";
        }
        System.out.println("enter 0 for  Stone , 1 for Paper and  2 for Scissor : ");

        Scanner sc = new Scanner(System.in);
        int myTurn = sc.nextInt();

        if(myTurn==0){
            if(a==2){
                System.out.println("its "+CTurn +"from my side");

                System.out.println("you won! hurray!");
            }
            else{
                System.out.println("its "+CTurn +"  from my side");

                System.out.println("you lost ! next try");
            }
        } else if (myTurn==1) {
            if(a==0){
                System.out.println("its "+CTurn +"from my side");

                System.out.println("you won! hurray!");

            }
            else{
                System.out.println("its "+CTurn +"from my side");

                System.out.println("you lost ! next try");
            }
        } else if (myTurn==2) {
            if (a==1){
                System.out.println("its "+CTurn + " from my side");

                System.out.println("you won! hurray!");
            }
            else{
                System.out.println("its "+CTurn +"from my side");

                System.out.println("you lost ! next try");
            }

        }
    }
}

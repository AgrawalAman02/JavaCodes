package conditionalStatement;

import java.util.Scanner;

public class PracticeSet4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        Q2----------------->>>>>>>>>>>>>>>>>>

//        System.out.println("marks1= ");
//        int marks1= sc.nextInt();
//        System.out.println("marks 2 =");
//        int marks2= sc.nextInt();
//        System.out.println("marks3= ");
//        int marks3= sc.nextInt();
//        float total = (marks1+ marks2+marks3)*.3f;
//        System.out.println("your overall percentage is " + total+"%");
//
//        if (total>=40&& marks1>=33&& marks2>=33 && marks3>=33){
//            System.out.println("you r pass after at all, ab khush rho!  :)  :)");
//        }
//        else {
//            System.out.println("sorry backlog lag gya :( fir se mehnat kriyo!");
//        }

//..........................Q2..................................................

//        System.out.print("enter your income in lakhs :- ");
//        float income = sc.nextFloat();
//        float tax = 0;
//
//        if (income<2.5){
//            tax +=0;
//            System.out.println("your income tax is "+tax+" . enjoy 👍");
//        } else if (income>=2.5f&&income<=5f) {
//            tax+= .05*(income - 2.5f);
//            System.out.println("your income(with 5 % tax ) tax is "+ tax);
//
//        } else if (income<=10f&& income >5f) {
//            tax +=(.05*2.5f);
//            tax+= (income-5f)*.2f;
//            System.out.println("your income(with 20% tax ) tax is "+ tax);
//
//
//        }
//        else{
//            tax += (.05*2.5f + .2*5f + (income - 10f)*.3f);
//            System.out.println("your income is (with 30% tax ) tax is "+ tax);
//        }

//        .........................................Q6...................................

        System.out.print("enter the url of website : ");
        String url = sc.nextLine();
        if (url.endsWith(".com")){
            System.out.println("its commercial website:)");
        } else if (url.endsWith(".org")) {
            System.out.println("its organisation website");
        }
        else {
            System.out.println("its indian website");
        }
    }
}

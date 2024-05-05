package cwhStrings;


import java.util.Scanner;

public class basicString {
    public static void main(String[] args) {
//        String name = new String("aman");

//        learn String are immuatable i.e. can't be changed

//        orrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
        String name ="harry";
        System.out.println(name);
        System.out.print(name);
        System.out.printf("\n %s", name); // like c language we cAn use format specifier
        System.out.format("\n same like printf \n");
        System.out.println("enter the string: ");
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        System.out.println(st);
    }
}


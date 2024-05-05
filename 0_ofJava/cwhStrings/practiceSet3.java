package cwhStrings;

public class practiceSet3 {
    public static void main(String[] args) {
        String aman = "hey How are you!";
/*
        ..................................................Q1......................................................

        //System.out.println(aman.toLowerCase());
        but i dont have to print lower case but i have to convert the given string
        so
        aman = aman.toLowerCAse();
        System.out.println(aman);

*/
//      ..............q2..............
        aman = aman.replace(" ","_");

        System.out.println(aman);

//        .................Q3.................

         String letter = "Dear <|name|>, Thanks a lot!";
         letter = letter.replace("<|name|>", "Aman");
        System.out.println(letter);

//        ................Q4................

        String myString= " This String  contains   Double and   Triple spaces";
        System.out.println(myString.indexOf("  "));
        System.out.println(myString.indexOf("   "));
//        if any of the above gives index = -1 then we can say thay are not present so thats why they gives neg. index
//        we can also do  by if else condition

//        ...........q5...........
        System.out.println("\"Dear Harry, This java course is nice. Thanks\"");
    }
}

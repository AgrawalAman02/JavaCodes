package cwhStrings;

import java.util.Scanner;

public class stringMethods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string u want : ");
        String st = sc.nextLine();
        System.out.println(st);

//        we have some methods to change the string ,, we cant change the existing string as string is immuatable so we make a copy of it we we store the changes

//        i> name.length...calculate the length of sting;
        int length = st.length();
        System.out.println(length);
//        ii> name.toLowerCase( IN SHORT WRITE tlc): returns a new string which has all th e lower case characters from the String "name"
        String lc = st.toLowerCase();
        System.out.println(lc);

//        iii>, name.toUpperCase;-

        String uc = st.toUpperCase();
        System.out.println(uc);

/*
        iv> name.trim :- returns a new string after removing all the leading and trailing spaces from the original String
        String nonTrimmedString = "  harry    ";
        System.out.println(nonTrimmedString);
        System.out.println(nonTrimmedString.trim());
*/
        System.out.println(st.trim());

//        v> name.substring(int start)____Returns a substring from start to the end ;
        System.out.println(st.substring(4));

//        vi>  name.substring(int start, int end)--> return a substring from start index(included) to end index(exluded)
        System.out.println(st.substring(3,7));

//        name.replace('r','p')--> returns a new string after replacing r with p ;
        System.out.println(st.replace('a','p'));
        System.out.println(st.replace("am","pq"));
//        we can also do by below🔻
        System.out.println(st.replace("a","bat"));

//        name.startsWith("Ha")--> returns true if starts with ha otherwise false;
        System.out.println(st.startsWith("am"));

//        name.endsWith("ry")-> returns true if na,e ends with ry
        System.out.println(st.endsWith("anu"));

//         name.charAt(2)--> returns character at a given index position;
        System.out.println(st.charAt(3));

//        name.indexOf(s)-> returns the index of given string(always return the index of first occurence)
        System.out.println(st.indexOf("n"));

//        name.indexOf("s",3)->  returns the index of the given string starting from the index 3(int)
        System.out.println(st.indexOf('a', 1));

//        name.lastIndexOf("r") -> returns the last index of the given string
        System.out.println(st.lastIndexOf("a"));
        System.out.println(st.lastIndexOf("a", 7));

//        name.equals("harry") = returns true if given strig is equals to harry otherwise false
        System.out.println(st.equals("aman kumar agr"));
        System.out.println(st.equalsIgnoreCase("AMAnkumaragr"));

//      name1.compareTo(name2)
        }
}

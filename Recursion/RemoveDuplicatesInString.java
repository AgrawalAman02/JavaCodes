package Recursion;

import java.util.Scanner;

public class RemoveDuplicatesInString {
    public static void removeDuplicates(String str,int idx,StringBuilder newStr, boolean map[]){
        if(idx== str.length()){
            System.out.println(newStr);
            return;
        }

        // kaam
        char currChar = str.charAt(idx);
        if(map[currChar-'a']== true){
            //duplicate
            removeDuplicates(str,idx+1,newStr,map);

        }
        else{
            map[currChar-'a']= true;
            removeDuplicates(str,idx+1,newStr.append(currChar),map);

        }
    }
    public static void main(String[] args) {
        System.out.println("enter your string(only lower case): ");
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
        removeDuplicates(str,0,new StringBuilder(""),new boolean[26]);
    }
}

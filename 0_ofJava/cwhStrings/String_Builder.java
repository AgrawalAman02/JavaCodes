package cwhStrings;

public class String_Builder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
//        sb.toString --- used to change into string
//        As sb =   new StringBuilder("aman"); then sb.toString changes it into string
//        actually sb.toString is iused to change anything into string
        for(char ch='a';ch<='z';ch++){
            sb.append(ch);
        }
        System.out.println(sb);
    }
}

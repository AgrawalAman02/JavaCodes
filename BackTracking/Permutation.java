package BackTracking;

import java.util.Scanner;

public class Permutation {
    public static void permutation(String str , String ans){
        if(str.length()==0){
            System.out.print(ans + "\t");
            return;
        }

        for(int i =0 ;i<str.length();i++){
            char current = str.charAt(i);
//            now we will remove thAT charater from original string by using substring
            // "abcde" => "ab" + "de" = "abde"
            String Newstr= str.substring(0,i) /*i not included*/ + str.substring(i+1);
            permutation(Newstr,ans+current);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string whouse u want to find the permutation: ");
        String str = sc.nextLine();
        permutation(str,"");
    }
}

//tc = n

package Stack;

import java.util.Scanner;
import java.util.Stack;

public class A11_BalancingMoreBrackets {

    static boolean isBALANCED(String str){
        Stack<Character> st = new Stack<>();
        int n = str.length();
        for(int i = 0;i<n;i++){
            char ch = str.charAt(i);
            if(ch=='('|| ch== '{'|| ch== '['){
                st.push(ch);
            }
            else{
                if(st.size()==0) return false;
                if(ch == ')' && st.peek() == '(') {
                    st.pop();
                } else if (ch=='}' && st.peek()== '{' ) {
                    st.pop();
                } else if (ch == ']' && st.peek()=='[') {
                    st.pop();
                }

            }
        }
        if(st.size()==0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the character of braces that  u want ot check for balancing brackets:--  ");
        String str = sc.nextLine();
        System.out.println(isBALANCED(str));
    }
}

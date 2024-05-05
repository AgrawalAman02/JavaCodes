package Stack;

import java.util.Scanner;
import java.util.Stack;

public class A11_Balancing_brackets {
    // push the op braces
    // if closing braces come pop the first op braces from stack but if i got the stk empty then return flse
    // if at end stack empty . so balanced
    static int left = 0,right = 0;
    static boolean isBalanced(String str){
        Stack<Character> st = new Stack<>();
        int n = str.length();
        for (int i = 0 ; i<n;i++){
            char ch = str.charAt(i);
            if(ch=='('){
//                left++;
                st.push(ch);
            }
            else{
//                right++;
                if(st.size()==0) return false;
                if(st.peek()=='(' )st.pop();
            }
        }
        
        if(st.size()>0) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter rhe string of (,)");
        String str = sc.nextLine();
        System.out.println(isBalanced(str));
        System.out.println(left+" "+right);
    }
}

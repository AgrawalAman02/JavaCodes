package Stack;

import java.util.Scanner;
import java.util.Stack;

public class A03_insert_At_Ith {
    public static void main(String[] args) {
        Stack <Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the index at where u want to insert: ");
        int idx = sc.nextInt();
        Stack<Integer> rt = new Stack<>();
        while(st.size()>idx){
            rt.push(st.pop());

        }
        System.out.println("enter the data to insert : ");
        int item = sc.nextInt();
        st.push(item);
        while(rt.size()>0){
            st.push(rt.pop());
        }
        System.out.println(st);
    }
}

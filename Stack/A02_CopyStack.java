package Stack;

import java.util.Scanner;
import java.util.Stack;

public class A02_CopyStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        int n;
        System.out.println("Enter the no. of elements u want in stack : ");
        n = sc.nextInt();
        System.out.println("enter the elements: ");
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            st.push(x);
        }
        System.out.println(st);

        Stack<Integer> rt = new Stack<>();
        while(st.size()>0){
//            int x= st.peek();
//            rt.push(x);
//            st.pop();

//            inspite of above three lines we can just only do it in one line
            // i.e. st.pop not only pop the element but also return popped element and peek just tell what on top
            rt.push(st.pop());
        }
        System.out.println(rt);
        Stack<Integer> tt = new Stack<>();
        while(rt.size()>0){
            int x= rt.peek();
            tt.push(x);
            rt.pop();
//              can only use the single line just above
        }
        System.out.println(tt);

    }
}

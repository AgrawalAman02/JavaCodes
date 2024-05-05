package Stack;

import java.util.Stack;

public class A06_displayRecursive {
    static void displayRec(Stack<Integer> st){
        if(st.size()==0){
//            st.push(8);
            return;
        }
        int top = st.pop();
        displayRec(st);
//        System.out.println(top);
        st.push(top);
    }

    static void insertBottomRec(Stack<Integer> st , int item){
        if(st.size()==0){
            st.push(item);
            return;
        }
        int top = st.pop();
        insertBottomRec(st,item);
        System.out.print(top+" ");

        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);
        displayRec(st);
        insertBottomRec(st,8);
        System.out.println();
        System.out.println(st);

    }
}

package Stack;

import java.util.Stack;

public class A08_RemoveFromIdxRec {
    static void removeIdxRec(Stack<Integer> st,int pos){
        if(st.size()==pos+1){
            st.pop();
            return;
        }
        int top = st.pop();
        removeIdxRec(st,pos);
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
        removeIdxRec(st,1);
        System.out.println(st);

    }
}

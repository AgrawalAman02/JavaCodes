package Stack;

import java.util.Stack;

// reverse the stack recursively......................................
public class A07_RevStkRec {

    static void insertBottomRec(Stack<Integer> st , int item){
        if(st.size()==0){
            st.push(item);
            return;
        }
        int top = st.pop();
        insertBottomRec(st , item);

        st.push(top);
    }

    public static void reverseRec(Stack<Integer> st){
        if(st.size()==1){   // at one element no need to do anything
            return;
        }
        int top = st.pop();   // removed the topmost element
        reverseRec(st);  // then recursion reverse the left element lets imagine
        insertBottomRec(st,top);  // then the top must be inseert at the bottom of the reversed left element
//    since we r continuosly popping element at at one time it will be empty then base case return then we insrt at the bottom the recent top so in this way it got reversed
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);
        reverseRec(st);
        System.out.println(st);
    }
}

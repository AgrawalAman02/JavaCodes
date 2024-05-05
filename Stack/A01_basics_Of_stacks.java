package Stack;
// LIFO op  or FILO
// stack has unlimited size means we can push any no. of elements
// for get an element in stack we have time as well as space complexity = O(N)
import java.util.Stack;    // this is the import statement for stack or we can use .*

public class A01_basics_Of_stacks {
    public static void main(String[] args) {
        // first we will see some built-in Stack
        // it is same as arrayList
        Stack<Integer> st = new Stack<>();
        // for adding we use st.push();
//        [] is the empty stack
        System.out.println(st.isEmpty());    // it is a boolean type tells st is empty or not
        st.push(1);
        System.out.println(st.isEmpty());    // it is a boolean type tells st is empty or not

        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        // peek - returns the topmost value of stack;
        System.out.println(st.peek());
//        to print the stack we can directly write st
        System.out.println(st);
        st.pop();
        System.out.println(st);
        System.out.println("size is : "+ st.size());
    }
}

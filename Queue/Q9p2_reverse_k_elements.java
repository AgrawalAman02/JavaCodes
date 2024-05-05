package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q9p2_reverse_k_elements {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(8);
        q.add(7);
        q.add(22);
        // if we have to reverse first 4 elements
        System.out.println(q);
        Stack<Integer> st = new Stack<>();
//        Queue<Integer> q2 = new LinkedList<>();

        while(q.size()>2) {
            st.push(q.remove());
        }
//        while(st.size()>0){
//            q2.add(st.pop());
//        }
//        while(q.size()>0){
//            q2.add(q.remove());
//        }
//        while(q2.size()>0){
//            q.add(q2.remove());
//        }
        while(st.size()>0){
            q.add(st.pop());
        }
        for(int i  = 0 ; i<2;i++){
            q.add(q.remove());
        }

        // so we can do it without using extra queue
        System.out.println(q);
    }

}

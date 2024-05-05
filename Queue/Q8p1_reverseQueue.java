package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q8p1_reverseQueue {
    public static void main(String[] args) {
        // we cant reverse queue directly as we do in stack by taking two stack as queue follows fifo
        // but we can reverse it by using a staCK where first we pop the element from queue and push to stack]
        // so in stack it enter in original way
//        but when we pop the stack and insert at queue it go in  reverse way
        // here we will do the reverse of queue not the kth reverse
        Queue<Integer> q = new LinkedList<>();
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(8);
        System.out.println(q);
        Stack<Integer> st = new Stack<>();
        while(q.size()>0) {
            st.push(q.remove());
        }
        while(st.size()>0){
            q.add(st.pop());
        }
        System.out.println(q);
    }
}

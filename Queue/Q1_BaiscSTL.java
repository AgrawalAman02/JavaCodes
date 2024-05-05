package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Q1_BaiscSTL {
    public static void main(String[] args) {
//        Queue<Integer> q = new Queue<>();    this throws an error as queue is an abstract type
//        Queue<Integer> q = new ArrayDeque<>();   // we can use this  as name suggests it uses array op
        Queue<Integer> q = new LinkedList<>();     // or we can do this as name suggests that it uses linked list op
        System.out.println("Queue's Emptiness :-> "+q.isEmpty());
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println("Queue's Emptiness :-> "+q.isEmpty());
        q.add(5);
        q.add(6);
        System.out.println("the size of queue is: "+ q.size());
        System.out.println(q);
        q.remove();    // for removing the fifo
        System.out.println(q);
//        or we can use .poll
        q.poll();
        System.out.println(q);
        System.out.println(q.peek());
//        or,
        System.out.println(q.element());
        System.out.println("the size of queue is: "+ q.size());



    }
}

package Queue;

import java.util.Deque;
import java.util.LinkedList;
// have to use both or *
public class Q7_DequeSTL {

    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addLast(1);
        dq.addLast(2);
        dq.addLast(3);
        dq.addLast(4);
        System.out.println(dq);
        dq.addFirst(43);
        dq.addFirst(69);
        System.out.println(dq);
        dq.removeLast();
        dq.removeFirst();
        System.out.println(dq);
        dq.remove();
        System.out.println(dq);
        dq.pop();    // can do popFirst and popLast
        System.out.println(dq);
        dq.poll();    // can do pollFirst and pollLast
        System.out.println(dq);
        dq.addLast(1);
        dq.addLast(2);
        dq.add(455);   // it add at last
        dq.add(98);
        System.out.println(dq);
        dq.addAll(dq);    //again add all dq
        System.out.println(dq);
        System.out.println(dq.getFirst());
        System.out.println(dq.getLast());
        System.out.println(dq.peekLast());   // can use peek in same way
        System.out.println(dq.getClass());
        //        dq.removeAll(dq);   remove everything
        dq.removeFirstOccurrence(1);    // on repetitive it remove first 1
        dq.removeLastOccurrence(455);   // on repetitive it remove last 455
        System.out.println(dq);

    }
}


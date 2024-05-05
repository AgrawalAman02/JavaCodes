package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q2_Printing {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        int[] arr = new int[q.size()];
        Queue<Integer> q1 = new ArrayDeque<>();
        for(int i = 0;i<arr.length;i++){
//            arr[i] = q.peek();
            System.out.print(q.peek() + "  ");
            q1.add(q.remove());
        }
        for(int i = 0;i<arr.length;i++){
            q.add(q1.remove());
        }
//        for(int i = 0; i<arr.length;i++){
//        System.out.print(arr[i] + "  ");
//        }

    }
}

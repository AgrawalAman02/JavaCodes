package Heap;
import java.util.*;
/*
Connect N ropes:
Given n ropes of different lengths , the task is to connect these ropes into one rope
with min cost , such that the cost to connect two ropes is equal to the sum of their lengths

 */
public class H05_NRopes {
    public static void main(String[] args) {
        int [] ropes = {2,3,3,4,6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i<ropes.length;i++){
            pq.add(ropes[i]);

        }

        int cost = 0;
        while(pq.size()>1){
            int min = pq.remove();
            int min2 = pq.remove();
            cost+= min + min2;
            pq.add(min+min2);
        }
        System.out.println("Cost of connecting n ropes = "+cost);
    }
}

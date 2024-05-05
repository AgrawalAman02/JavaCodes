package Heap;
import java.util.*;

public class H02_Implemention {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            // add at last index
            arr.add(data);

            int x = arr.size()-1; // x is the child idx;
            int par = (x-1)/2;    // par index

            while(arr.get(x) <arr.get(par)){
                // swap
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x = par;
                par = (x-1)/2;
            }
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if(left<arr.size() && arr.get(minIdx)>arr.get(left)){  //  left<arr.size()  - because if i is the leaf node then left and right child idx will greater than size of arr so to negate that we compare already
                minIdx = left;
            }
            if(right<arr.size() && arr.get(minIdx) > arr.get(right)) minIdx = right;

            if(minIdx!= i) {  // means if minIdx is not root or left or right is min then value got changrd above then so swap to be done with the min value to root
                // swap
                int temp = arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);

                heapify(minIdx);   // if more fixing to be done in subsequent child tree
            }
        }

        public int remove(){
            int data = arr.get(0);

            // step 1 : swap first & last
            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // Step2- delete last;
            arr.remove(arr.size()-1);

            //Step 3- Heapify:- It is private function that us not used by everyone but this heap class call it
            heapify(0);
            return  data;
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(!h.isEmpty()){  // since it throw data in sorted order so called *****HEAP SORT*****
            System.out.println(h.peek());
            h.remove();
        }
        // we will see that peek is done in  ascending order just like priority queue\
//        priority queue use head data structure
    }
}

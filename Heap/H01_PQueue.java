package Heap;
import java.util.Comparator;
import java.util.PriorityQueue;
public class H01_PQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());  //by default is ascending . but for descending priority- This comparator is a interface having revese order a function to reverse the logic of anything . this is also used in sort in arr in revrse
        pq.add(3);  // TC = O(log(n))
        pq.add(1);
        pq.add(4);
        pq.add(7);

        while(!pq.isEmpty()){
            System.out.println(pq.peek());   //tc = O(1)
            pq.remove();  // TC = O(log(n))
        }
//        System.out.println("We added first 3 but 1 is removed first as 1 is highest priority as ascending order is decision criteria");
        PriorityQueue<Student> pqq = new PriorityQueue<>();
        pqq.add(new Student("A",4));
        pqq.add(new Student("B",5));
        pqq.add(new Student("C",2));
        pqq.add(new Student("D",12));

        while(!pqq.isEmpty()){
            System.out.println(pqq.peek().name+" -> "+ pqq.peek().rank);   //tc = O(1)
            pqq.remove();  // TC = O(log(n))
        }
//        so student sorted as per their rank
        // for reversing we can use Comparator.reverseOrder()
    }
    // this priority queue can add int , string anything but to store object we do following thing
    // to implements priority in class we use interface Comparable<>
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank-s2.rank;
        }
    }
}

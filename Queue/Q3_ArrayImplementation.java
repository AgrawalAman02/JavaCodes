package Queue;

public class Q3_ArrayImplementation {
    public static class QueueA {
        int front = -1;
        int rear = -1;
        int n = 7;
        int[] queue = new int[n];

        // we can also define size variable heer which inc on inserting and dec on deletion

        public void add(int item) {
            if (rear == n - 1) System.out.println("Queue Qverflow");
            else{
                if (front == -1 && rear == -1) {
                    front = 0;
                    rear = 0;
                } else {
                    rear++;
                }
                queue[rear] = item;
            }
        }

        public int removeQ() {
            if (front == -1 && rear ==-1){
                System.out.println("Queue underflow");
                return -1;
            }
            else {
                int item=0;
                if (front == rear) {
                    rear = -1;
                    front = -1;
                } else{
                    item = queue[front];
                    front ++;
                }
                return item;
            }
        }
        public int peek(){
            if (front == -1 && rear ==-1){
                System.out.println("Queue is empty");
                return -1;
            }
            return queue[front];
        }

        public void display(){
            if(front == -1 && rear ==-1){
                System.out.println("Queue is empty");
                return;
            }
            for(int i=front;i<=rear;i++){
                System.out.print(queue[i]+" ");
            }
            System.out.println();
        }
        public boolean isEmpty(){
            if (front == -1 && rear ==-1){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        QueueA  q = new QueueA();
        System.out.println(q.isEmpty());
        q.display();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.peek());
        q.add(6);
        q.add(8);
        q.add(9);
        q.display();
        q.add(78);
        q.display();
        q.removeQ();
        q.removeQ();
        q.removeQ();
        q.removeQ();
        q.display();
        q.add(2344);
        q.removeQ();
        System.out.println(q.peek());
        q.removeQ();
        q.removeQ();
        q.removeQ();
        q.display();
    }
}

/*
Disadvantages:
    -> It has fixed size.
    -> when we are removing some items then the array place remain empty for that removed place
       and when rear went to max place then inspite arr is empty at somewhere iun front we can insert any element
 */

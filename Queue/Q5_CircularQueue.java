package Queue;

public class Q5_CircularQueue {
    public static class CQueue{
        int front = -1;
        int rear = -1;
        int n = 7;
        int item;
        private int[] cqueue = new int[n];  // so that it cant be accessed by main
            // we can also use size var.
        public void insert(int item) throws Exception{
            if(front == 0 && rear == n-1 || front ==  rear+1){
                throw new Exception("Queue Overflow");
            }
            else{
                if(front == -1){
                    front = rear = 0;
                } else if(rear == n-1){
                    rear = 0;
                } else {
                    rear ++;
                }
                cqueue[rear] = item;
            }
        }

        public int delete() throws Exception{
            if(front == -1 && rear == -1){
                throw new Exception("Queue Underflow");
            } else{
                item = cqueue[front];
                if(front == rear) front = rear= -1;
                else if (front == n-1) front = 0;
                else front ++;
            }
            return item;
        }
        public int peek() throws Exception{
            if(front == -1 && rear == -1) {
                throw new Exception("Queue Underflow");
            } else return cqueue[front];
        }
        public void display(){
            if(front == -1 && rear == -1){
                System.out.println("Queue Underflow");
                return;
            } else{
                if(front<=rear){
                    for(int i = front;i<= rear;i++){
                        System.out.print(cqueue[i]+" ");
                    }
                } else{
                    for(int i = front;i<= n-1;i++){
                        System.out.print(cqueue[i]+" ");
                    }
                    for(int i = 0;i<= rear;i++){
                        System.out.print(cqueue[i]+" ");
                    }
                }
            }
            System.out.println();
        }

    }
    public static void main(String[] args) throws Exception {
        CQueue q = new CQueue();
        q.display();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);
        q.insert(6);
        q.insert(7);
        q.display();
        q.delete();
        q.delete();
        q.delete();
        q.delete();
        q.display();
        q.insert(8);
        q.insert(1);
        q.delete();
        q.delete();
        q.insert(1);
        q.display();
        System.out.println(q.peek());
        q.insert(56);
        q.insert(567);
        q.insert(69);
        q.display();
        q.delete();
        System.out.println(q.peek());
        q.display();
    }
}

package Queue;

public class Q6_CQueueLL_Implemtation {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static class QueueL {
        Node head = null;
        Node tail = null;
        int item;

        public void add(int item) {
            Node temp = new Node(item);
            if (head == null && tail == null) {
                head = temp;
                tail = head;
                tail.next = head;    // for circular
            } else {
                tail.next = temp;
                tail = temp;
                tail.next = head;  // for circular
            }
        }

        public int delete() {
            if (head == null && tail == null) {
                System.out.println("Queue underflow");
                return -1;
            }
            item = head.data;
            head = head.next;
            tail.next = head;    // for circular
            return item;
        }

        public int peek() {
            if (head == null && tail == null) {
                System.out.println("Queue underflow");
                return -1;
            }
            return head.data;
        }

        public void display() {
            if (head == null && tail == null) {
                System.out.println("Queue is empty");
                return;
            }
            Node temp = head;
            do {
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            } while (temp != head);
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        QueueL q = new QueueL();
        q.display();
        q.delete();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.display();
        System.out.println(q.peek());
        q.delete();
        q.delete();
        System.out.println(q.peek());
        q.add(45);
        q.add(67);
        q.display();
        q.delete();
        q.display();
    }
}


package Linked_List;
//remove the consecutive duplicates

public class practice_08_duplicates {
    static Node head = null;
    static Node head1 = null;

    public static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void display(Node node) {
        Node temp = node;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null\n");
    }

    static void remove_consecutive_duplicates(){
        Node tail = head;
        while(tail!=null){
            while(tail.data== tail.next.data){
                tail.next= tail.next.next;
                if(tail.next== null) break;
            }
            tail= tail.next;
        }
        display(head);

    }
    static void remove_consecutive_duplicates_extraPtr(){
        Node tail = head;
        Node temp= new Node(100);
        head1 = temp;
        while(tail!=null){
            temp.next= tail;
            temp = temp.next;
            tail= tail.next;

            while(temp.data== tail.data){
                tail= tail.next;
                if (tail==null) break;
            }
            temp.next=null;

        }
        head1 = head1.next;
        display(head1);

    }


    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(1);
        Node c = new Node(5);
        Node d = new Node(6);
        Node e = new Node(6);
        Node f = new Node(6);
        Node g = new Node(15);
        Node h = new Node(15);
        head = a;
        a.next =b;
        b.next =c;
        c.next =d;
        d.next =e;
        e.next =f;
        f.next =g;
        g.next = h;
//        remove_consecutive_duplicates();
        remove_consecutive_duplicates_extraPtr();

//        both methods are correct
    }
}

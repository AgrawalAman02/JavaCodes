package Linked_List;

public class practice_19_Max_Min_distance {
    static Node head = null;

    static class Node {
        Node prev;
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
    static void critical(){
        Node temp1 = head.next;
        Node temp2 = head;
        while (temp2.next.next != null) {
            temp2 = temp2.next;
        }
        if(temp1.data>temp1.prev.data&& temp1.data> temp1.next.data){
            Node c1 = temp1;

        }
        if(temp1.data<temp1.prev.data&& temp1.data<temp1.next.data){
            Node c1 = temp1;
        }
        if(temp2.data>temp2.prev.data&& temp2.data> temp2.next.data){
            Node c2 = temp2;

        }
        if(temp2.data<temp2.prev.data&& temp2.data<temp2.next.data){
            Node c2 = temp2;
        }

        int length = 0;

    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(5);
        Node d = new Node(3);
        Node e = new Node(2);
        Node f = new Node(7);
        Node g = new Node(8);
        Node h = new Node(9);
        Node i = new Node(1);
        Node j = new Node(10);

        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = e;
        e.prev = d;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;
        f.prev = e;
        g.prev = e;
        h.prev = f;
        i.prev = g;
        j.prev = i;

        head = a;
    }
}

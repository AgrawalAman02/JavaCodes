package Linked_List;

public class practice_03_Intersection {
    static Node head1 = null;
    static Node head2 = null;
    public static class Node{

        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static void display(){
        Node temp = head1;
        Node temp1 = head2;
        while(temp!=null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
        while(temp1!=null){
            System.out.print(temp1.data + " -> ");
            temp1 = temp1.next;
        }
        System.out.print("null\n");
    }

    public static  Node intersecting_Node(){
        Node tail1 = head1;
        Node tail2 = head2;

        int size1=0, size2 = 0;
        while(tail1!=null){
            size1++;
            tail1=tail1.next;
        }
        while(tail2!=null){
            size2++;
            tail2=tail2.next;
        }

        tail1 = head1;
        tail2 = head2;
        int i =0;
        if(size1>size2) {
            int n = size1 - size2;
            while (i != n) {
                tail1 = tail1.next;
                i++;
            }
        }
        else{
            int n = size2 - size1;
            while (i != n) {
                tail2 = tail2.next;
                i++;
            }
        }
        while(tail1!=null&&tail2!=null){
            if(tail1==tail2){
                return tail2;
            }
            tail1=tail1.next;
            tail2=tail2.next;
        }
        return null;
        /*
        or we can write
        while(tail1!=tail2){
            tail1=tail1.next;
            tail2=tail2.next;
        }
        return tail1;
         */
    }

    public static void main(String[] args) {
        Node a = new Node(11);
        Node b = new Node(22);
        Node c = new Node(33);
        Node d = new Node(44);
        Node e = new Node(55);
        Node f = new Node(66);
        Node g = new Node(77);
        Node h = new Node(12);
        Node i = new Node(23);

        head1 = a;

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        head2 = h;
        h.next = i;
        i.next = e;
        display();
        Node common = intersecting_Node();
        System.out.println(common.data);
    }
}

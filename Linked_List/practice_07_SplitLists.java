package Linked_List;

public class practice_07_SplitLists {
    static Node head = null;
    static Node head1 = null;
    static Node head2 = null;
    public static class Node{
        int  data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static void display(Node node) {
        Node temp = node;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");

    }

    static void split(){
        Node odd = new Node(100);
        Node even = new Node(101);
        head1 = odd;
        head2 = even;
        Node temp = head;
        while(temp != null){
            if(temp.data%2!=0){
                odd.next = temp;
                temp = temp.next;
                odd = odd.next;
                odd.next= null;
            }
            else{
                even.next = temp;
                temp = temp.next;
                even = even.next;
                even.next= null;
            }
//            temp= temp.next;
        }
        head1= head1.next;
        head2= head2.next;
        display(head1);  // not display odd bcoz odd come to end
        display(head2);   // same
    }
    public static void main(String[] args) {
        Node b = new Node(2);
        Node c = new Node(5);
        Node a = new Node(1);
        Node d = new Node(6);
        Node e = new Node(8);
        Node f = new Node(9);
        Node g = new Node(15);
        head = a;
        a.next =b;
        b.next =c;
        c.next =d;
        d.next =e;
        e.next =f;
        f.next =g;
        split();
    }
}

package Linked_List;
// arrange the odd index node at start and even index node after that
public class practice_13_OddEvenLinkList {
    static Node head = null;
    static class Node{
        int data;
        Node next ;
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
        System.out.println("null\n");
    }

    static void oddEvenlist(Node head){
        Node odd = new Node(0);
        Node even = new Node(0);
        Node tempo = odd;
        Node tempe = even;
        Node temp= head;
        while(temp!= null){
            tempo.next= temp;
            temp = temp.next;
            tempo= tempo.next;
            if(temp==null) {
                break;
            }
            tempe.next = temp;
            temp= temp.next;
            tempe=tempe.next;

        }
        odd = odd.next;
        even = even.next;
        tempo.next= even;
        display(odd);
    }
    public static void main(String[] args) {
        Node  a = new Node(11);
        Node  b = new Node(13);
        Node  c = new Node(17);
        Node  d = new Node(14);
        Node  e = new Node(16);
        Node  f = new Node(121);
        head = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        oddEvenlist(a);
    }
}

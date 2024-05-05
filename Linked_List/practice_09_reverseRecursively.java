package Linked_List;

public class practice_09_reverseRecursively {
    static Node head = null;

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data= data;
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
    static Node reverse_Recursive(Node head){
        if(head.next==null) return head;
        Node newNode = reverse_Recursive(head.next);
        head.next.next = head;
        head.next= null;
        return newNode;
    }

    static void reverse_Iteratively(){
        Node temp = head;
        Node old = null;
        Node neww = null;
        while(temp!=null){
            neww = temp.next; // Store the next node
            temp.next= old;   // Reverse the current node's next pointer
            old= temp;        // Move prev to the current node
            temp=neww;        // Move current to the next node
        }
//        now the new head is old
        head = old; // Update the head to the new first node in the reversed list
        display(head);
    }

    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(1);
        Node d = new Node(2);
        Node e = new Node(4);
        head = a;
        a.next =b;
        b.next =c;
        c.next =d;
        d.next =e;

        display(a);
//        a = reverse_Recursive(a);   // t.c = O(n)  s.c = O(1)
        reverse_Iteratively();
    }
}

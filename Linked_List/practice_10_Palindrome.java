package Linked_List;

public class practice_10_Palindrome {
    static Node head = null;
    static Node head2 = null;
    static class Node{
        int data;
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
        System.out.println("null\n");
    }

    static boolean isPalindrome1(){
        Node temp = head;
        Node temp2 = new Node(100);
        head2 = temp2;
        while(temp!= null){
            Node tempo = new Node(temp.data);
            temp2.next= tempo;
            temp2= tempo;
            temp= temp.next;
        }
        head2 = head2.next;
        display(head);
        display(head2);
        temp = head;
        Node old = null;
        Node after = null;
        while(temp!=null){
            after = temp.next;
            temp.next= old;
            old = temp;
            temp= after;

        }
        head = old;
        display(head);
        temp = head;
        temp2 = head2;
        while(temp!=null&&temp2!=null){
            if(temp.data!=temp2.data) {
                return false;
            }
            temp= temp.next;
            temp2= temp2.next;
        }
        return true;
    }

//    another method

    static boolean isPalindrome2(){
        Node slow= head;
        Node fast = head;
        Node temp = null;
        while(fast.next!= null && fast.next.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
//        now reverse the node after slow ptr
        temp = slow.next;
        Node old = null;
        Node after = null;
        while(temp!=null){
            after = temp.next;
            temp.next= old;
            old = temp;
            temp= after;

        }
        temp = old;  // re initialise the temp to old which has been reversed
        slow . next = old;  // linking slow to the reverse list
        Node p1 = head;
        while(temp!= null){
            if(p1.data != temp.data) {
                return false;
            }
            p1=p1.next;
            temp=temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(3);
        Node e = new Node(2);
        Node f = new Node(1);
        head = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        System.out.println(isPalindrome1());
        System.out.println(isPalindrome2());
    }
}

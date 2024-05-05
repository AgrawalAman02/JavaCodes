package Linked_List;

public class practice_17_doubly_Palindrome {
    static Node head = null;
    static class Node{
        Node prev;
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    static Boolean isPalindrome(){
        Node temp1 = head;
        Node temp2 = head;
        while(temp2.next!=null){
            temp2= temp2.next;
        }
        while(temp2!=temp1&& temp2!=temp1.prev){
            if(temp1.data!=temp2.data) {
                return false;
            }
            temp1= temp1.next;
            temp2= temp2.prev;
        }
        return true;
    }
    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(2);
        Node d = new Node(10);
        Node e = new Node(4);
        head = a;
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = e;
        e.prev = d;
        System.out.println(isPalindrome());
    }
}

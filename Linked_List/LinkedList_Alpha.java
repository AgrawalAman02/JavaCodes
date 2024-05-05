package Linked_List;

public class LinkedList_Alpha {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;
    public static Node tail;

    public static void main(String[] args) {
        LinkedList_Alpha l1 = new LinkedList_Alpha();
        l1.head = new Node(1);
        l1.head.next = new Node(2);
    }
}

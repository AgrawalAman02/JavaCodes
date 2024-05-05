package Linked_List;
// doubly linked list takes even more men=mory than single liked list which also takes extra
public class practice_15_DoublyLinkedList {

    static Node head = null;
    static Node tail = null;
    static class Node {
        Node prev;
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    static int size(){
        int size = 0;

        Node temp = head;
        while(temp!= null){
            size++;
            temp= temp.next;
        }
        return  size;
    }

    // displaying using head
    static void display(Node node){
        Node temp = node;
        System.out.print("null -> ");
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }
            // displaying using tail
    static void displayrev(Node tail){
        Node temp = tail;
        System.out.print("null -> ");
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.prev;
        }
        System.out.print("null\n");
    }

    static void displayRight_fromRandom(Node rand){
        Node temp = rand;
        System.out.print("null -> ");
        // move this temp until i go to head
        while (temp.prev != null) {
            temp = temp.prev;
        }
        // now temp is at head
        while(temp!=null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    static void insert_AtHead(int item){
        Node temp = new Node(item);
        temp.next = head;
        head.prev = temp;
        head = temp;
        display(head);
    }
    static void insert_AtEnd(int item){
        Node temp = head;
        Node temp1 = new Node(item);
        while (temp.next != null) {
            temp = temp.next;
        }
        temp1.prev = temp;
        temp.next = temp1;
        temp = temp.next;  // not necessary
        display(head);
    }

    static void insert_AtPos(int pos,int item){
        if (pos < 1 || pos > size() + 1) {
            System.out.println("Invalid position");
            return;
        }
        Node temp = head;
        Node temp1 = new Node(item);
        int i = 1;
        if(pos==1){
            insert_AtHead(item);
            return;
        } else if (pos==size()+1) {
            insert_AtEnd(item);
            return;
        }
        while(i<pos-1){
            temp = temp.next;
            i++;
        }
        temp1.next = temp.next;
        temp.next.prev = temp1;
        temp1.prev= temp;
        temp.next = temp1;
        temp = temp.next;  // not necessary
        display(head);
    }
    static void deleteHead(){
        Node temp = head;
        head = head. next;
        head.prev= null;
        display(head);
    }
    static void deleteTail(){
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp  = temp.prev;
        temp.next = null;
        display(head);
    }

    static void delete_AtPos(int pos){
        if (pos < 1 || pos > size()) {
            System.out.println("Invalid position");
            return;
        }
        Node temp = head;
        if(pos==1){
            deleteHead();
            return;
        } else if (pos==size()) {
            deleteTail();
            return;
        }
        int i =0;
        while(i<pos-1){
            temp = temp.next;
            i++;
        }
        temp.prev.next= temp.next;
        temp.next.prev = temp . prev;
        display(head);

    }
    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(2);
        Node d = new Node(99);
        Node e = new Node(13);
        head = a;
        a.prev = null ; // already prev -> null by default
        a.next = b;
        b.prev = a;
        b.next =c;
        c.prev= b;
        c.next= d;
        d.prev = c;
        d.next =e;
        e.prev = d;
        e.next = null;
        display (a);      // displaying using head
        displayrev(e);            // displaying using tail
//          if i only know the tail or from any random node and i want to print in original order not in rev
        displayRight_fromRandom(e);
        displayRight_fromRandom(c);
        insert_AtHead(31);
        insert_AtEnd(23);
        System.out.println("the size is "+ size());
        insert_AtPos(4,77);
        deleteHead();
        deleteTail();
        delete_AtPos(3);
    }
}

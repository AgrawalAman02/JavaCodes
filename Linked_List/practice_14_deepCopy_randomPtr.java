/*
copy list with random Ptr : Construct a deep copy of a linked list where
each node contains an additional random ptr , which could point to anu node in the list or null

-->
    1. each node have an extra field i.e. node field named Random
    2. first make a normal deep copy lit where each random of each node is pointing to null
    3. connect alternate connections i.e first element of og list connct to first of copy then 1 copy to 2 og then 2 og to 2 copy and so on...
        using an extra initial node
    4. do t2.random = t1.random.next
        while:
            t1= t1.next.next;
            t2= t2.next.next;
    5. seprate the joined list
    6 t1.next = t2.next;     t1= t1.next
    7. t2.next = t1.next;    t2= t2.next

 */
package Linked_List;

public class practice_14_deepCopy_randomPtr {
    static Node head = null;
    static class Node {
        int data;
        Node next;
        Node random;
        Node(int data){
            this.data = data;
        }
    }

    static Node copyRandomList(Node head){
        Node head2 = new Node(0);
        Node temp1 = head;
        Node temp2 = head2;
        // creating deep copy
        while(temp1!= null){
            Node t = new Node(temp1.data);
            temp2.next = t;
            temp2 = temp2.next;
            temp1= temp1.next;
        }
        head2= head2.next;
        temp2 = head2;
        temp1 = head;

        // alternate connection
        Node temp = new Node(-1);
        while(temp1!=null){
            temp.next=temp1;
            temp = temp.next;
            temp1= temp1.next;

            temp.next = temp2;
            temp2= temp2.next;
            temp = temp.next;
        }
        temp2 = head2;
        temp1 = head;

        while(temp1!=null&& temp2!=null){
            if(temp1.random == null) temp2.random = null;
            else {
                temp2.random = temp1.random.next;
            }
            temp1 = temp2.next;
            if(temp1!=null) temp2 = temp1.next;
        }
        temp2 = head2;
        temp1 = head;
        // sepration
        while(temp1!=null){
            temp1.next = temp2.next;
            temp1 = temp1.next;
            if(temp1==null) break;
            temp2.next = temp1.next;
            if(temp2.next== null) break;
            temp2= temp2.next;
        }
        return head2;
    }

    public static void main(String[] args) {
        Node a = new Node(7);
        Node b = new Node(13);
        Node c = new Node(11);
        Node d = new Node(10);
        Node e = new Node(1);

        head = a;

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

//        now connecting random ptr

        a.random = null;
        b.random = a;
        c.random = e;
        d.random = c;
        e.random = a;

        Node rand= copyRandomList(head);

    }
}

package Linked_List;

public class Practice_06_merge {
    static Node head1 = null;
    static Node head2 = null;
    static Node head = null;
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    static void merge_ExtraSpace(){
        Node temp1 = head1;
        Node temp2= head2;
        Node temp = new Node(100);
        head = temp;
        // on the basis of merge sort algorithm we r doing this
        while(temp1!=null && temp2!= null ){
            if(temp1.data <= temp2.data){
                Node temp3 = new Node(temp1.data);
                temp.next= temp3;
                temp = temp3;
                temp1= temp1.next;
            }
            else{
                Node temp3 = new Node(temp2.data);
                temp.next= temp3;
                temp = temp3;
                temp2 = temp2.next;
            }
        }

        if(temp1==null){
            temp.next = temp2;
        }
        else{
            temp.next = temp1;
        }
        head = head.next;

    }

    static void merge_inPlace(){
        Node temp1 = head1;
        Node temp2= head2;
        Node curr = new Node(100);
        head = curr;

        while(temp1!=null&& temp2!=null){
            if(temp1.data<=temp2.data ){
                curr.next=temp1;
                temp1=temp1.next;
//                curr= curr.next;
            }
            else{
                curr.next = temp2;
                temp2 = temp2.next;
//                curr = curr.next;
            }
            curr = curr.next;

        }
        if(temp1==null){
            curr.next = temp2;
        }
        else{
            curr.next = temp1;
        }
        head = head.next;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(5);
        Node d = new Node(6);
        Node e = new Node(8);
        Node f = new Node(9);
        Node g = new Node(15);
        head1 = a;
        a.next =b;
        b.next =c;
        c.next =d;
        d.next =e;
        e.next =f;
        f.next =g;

        Node a1 = new Node(2);
        Node h = new Node(4);
        Node i = new Node(7);
        Node j = new Node(10);
        Node k = new Node(11);
        head2 = a1;
        a1.next= h;
        h.next = i;
        i.next = j;
        j.next = k;
//        merge_ExtraSpace();
        merge_inPlace();
        display();
    }
}

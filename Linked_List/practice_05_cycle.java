package Linked_List;

public class practice_05_cycle {
    static Node head = null;

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data= data;

        }
    }

    static boolean checkCyclic(){
        Node fast = head;
        Node slow = head;
        while(fast!=null){
            if(head == null) return false;
            if(head . next == null){   // for single element
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }

    public static Node cycleDetection(){
        Node fast = head;
        Node slow= head ;
        Node temp = head;
        while(fast!= null){
            fast = fast.next.next;
            slow= slow.next;
            if(fast == slow){
                break;
            }
        }
        while(temp!=slow){
            slow= slow.next;
            temp = temp.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node a = new Node(11);
        Node b = new Node(22);
        Node c = new Node(33);
        Node d = new Node(44);
        head = a;
        a.next = b;
        b.next = c;
        c.next= d;
        d.next= b;   // this makes it aa  cyclic list

        System.out.println(checkCyclic());
        System.out.println(cycleDetection().data);
    }
}

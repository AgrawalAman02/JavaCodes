package Linked_List;

import java.util.Scanner;

public class practice_04_middle {
    static Node head = null;
    static int item;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
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

    static Node findMid(int n) {
        Node tail = head;
        int mid = ((n + 1) / 2) - 1;  // as size is 1 based numebering and list is 0 based
        int i = 0;
        while (i != mid) {
            tail = tail.next;
            i++;
        }
        return tail;
    }

    static Node findMid_twoPtr() {
        Node fast = head;
        Node slow = head;
        while (fast != null) {          // in even case ,for getting left mid use extra (.next)with fast
            if (fast.next == null) {    // in even case ,for getting left mid use extra (.next)ith fast
                fast = fast.next;
//                we can write the above line or we can directly return the slow
                return slow;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static void deleteMid() {
        Node fast = head;
        Node slow = head;
        Node old = head;
//        while(fast!=null){          // in even case ,for getting left mid use extra (.next)with fast
//            if(fast.next== null){    // in even case ,for getting left mid use extra (.next)ith fast
//                fast= fast.next;
//                old.next = slow.next;
//                display();
//                return;
//            }
//            fast = fast.next.next;
//            old = slow;
//            slow= slow.next;
//        }
//        old.next = slow.next;

//            inspite of doing above where we are doing if condition and displaying there alsp we can use both conditon in while in his delete and in mid method above also...

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            old = slow;
            slow = slow.next;

            // Now, 'slow' points to the middle node
            // Update 'old.next' to skip over the middle node
        }
        old.next = slow.next;
        display();
    }

//      if we dont want to use old node or only two node then we stop in a prev step or check for one extra step
//    done below
    static void delete_mid_twoptr(){
        Node fast = head;
        Node slow = head;

        while(fast.next.next != null && fast.next.next.next != null) {

            if(head.next==null){//            if single element is present in list
                return;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next=slow.next.next;
        display();
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the List:- ");
        n = sc.nextInt();
        System.out.println("Enter the item 1 for list :- ");
        item = sc.nextInt();
        Node tail = new Node(item);
        head = tail;
        for(int i =2;i<=n;i++){
            System.out.println("Enter the item "+i+" for List :- ");
            item = sc.nextInt();
            Node temp = new Node(item);
            tail.next = temp;
            tail= tail.next;
        }
        display();
        System.out.println("the data of mid node is : "+ findMid(n).data);
        System.out.println("the data of mid node with two ptr is : "+ findMid_twoPtr().data);
//        deleteMid();
//        if we dont want to use old node or only two node then we stop in a prev step or check for one extra step
//    done below
        delete_mid_twoptr();
    }

}

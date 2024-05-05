package Linked_List;

import java.util.Scanner;
//         we have to find the nth node from the end if we know only head node


public class practice_02 {
    static int item;
    static Node head = null;
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static void display(){
        Node temp = head;

        while(temp!=null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public static Node nthNode(int pos){
        Node tail = head;
        int size = 0;
        while(tail!=null){
            size++;
            tail= tail.next;

        }
        tail = head;
        int j = size-pos+1;
        for(int i = 0;i<j-1;i++){
            tail= tail.next;
        }
        return tail;
    }
    static Node getNth_FLast(int pos){
        Node fast = head;
        Node slow = head;
        int i = 0;
        while(i<pos){
            fast = fast.next;
            i++;
        }
//        above will iterate the fast pointer upto pos step;
//        after that we will advance both pointer untl fast dnt get null
//        then we will see that slow s at that node tha we are in need
        while(fast!=null){
            slow= slow.next;
            fast= fast.next;
        }
        return slow;
    }
//      Q3
    //Removing Nth Node from the end of Linked List (only 1 traversal)
//---> we can do by two traversal as first we traverse and find the pos of that  node from start AND then delete that node using delete op.
    static void delete_Nth_node(int pos){
        Node fast = head;
        Node slow = head;
        int i = 0;
        while(i<pos){
            fast = fast.next;
            i++;
        }
//        we will now iterate the fast not until null but until tail because due to this the slow will remain at the node before node to be deleted
//        because for deletion we need old node

//        now  in slow.next we put the address of  slow.next.next i.e next to node to be deleted
//        in this way node is deleted

//        now on running we see that it can able to delete 1st node from last (means last node) also other nodes
//        but it cant able to  delete nth node from last i.e. head node.why?
//        because on running the loop n (n= total no. of elements in list as only n == n  then we can delete first node )times fast goes upto null , so
//        so in while condition fast.next is null.next means nothing so loop not work
//         so we put a checkmark if fast == null then head = head.next

        if(fast == null){
            head = head.next;  // in this way we are deleting first node if it was the case
            return;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

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

        System.out.println("enter the pos from last at which u wanna get node: - ");
        int pos = sc.nextInt();
        display();
        System.out.println("the required data of node from last is:- "+nthNode(pos).data);

//        since we are traversing two times in the list
//        if we are asked to do only one traversal then we use two pointer as used in my new method
        System.out.println("the required data of required node from last  by 2 pointer approach is:- "+getNth_FLast(pos).data);
        System.out.println("enter the position from last where u want to delete node :- ");
        pos = sc.nextInt();
        delete_Nth_node(pos);
        display();
    }
}

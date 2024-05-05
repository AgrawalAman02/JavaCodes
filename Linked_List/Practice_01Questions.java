package Linked_List;

import java.util.Scanner;

public class Practice_01Questions {

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
        System.out.print("null");
    }

    public static class Question1{
        //can we delete a node given that the node itself a parameter
        //means here we r getting the node that has to be deleted but we are mot have the head node means we have to delte the node which is given
        // node shouldn't be last node

        void deleteNode(Node node){
            node.data = node.next.data;
            node.next= node.next.next;
//            here we are shifting the value of next node to previous nodde which is to be deleted
//            in this way we are not actually deleting the node but we are erasing the values of that node
        }
    }

    public static class Question2{
//         we have to find the nth node from the end if we know only head node

    }
    public static void main(String[] args) {



//       for Question 1 class

        Node a = new Node(5);
        head = a;

        Node b = new Node(6);
        Node c = new Node(7);
        Node d = new Node(8);
        Node e = new Node(9);
        // 5 6 7 8 9
        a.next = b;     // 5 -> 6 7 8 9
        b.next = c;     // 5 -> 6 -> 7 8 9
        c.next = d;     // 5 -> 6 -> 7 -> 8 9
        d.next = e;     //

        Question1 q1 = new Question1();
        display();
        q1.deleteNode(d);
        System.out.println();
        display();

    }
}

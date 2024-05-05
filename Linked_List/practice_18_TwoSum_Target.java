package Linked_List;

import java.util.Scanner;

public class practice_18_TwoSum_Target {
    static Node head = null;
    static class Node{
        Node prev;
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    static void twinSum(int target){
        Node temp1 = head;
        Node temp2 = head;

        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        int op1=-1;
        int op2 =-1;
        while (temp1.data<temp2.data){
            if(temp2.data+ temp1.data==target){
                op1 = temp1.data;
                op2 = temp2.data;
                break;
            } else if (temp2.data+ temp1.data<target) {
                temp1=temp1.next;
            } else{
                temp2= temp2.prev;
            }

        }
        if (op1 != -1 && op2 != -1) {
            System.out.println(op1 + " + " + op2 + " = " + target);
        } else {
            System.out.println("No pair found that sums up to the target.");
        }
    }
    public static void main(String[] args) {
//        the list should be sorted
        Node a = new Node(4);
        Node b = new Node(7);
        Node c = new Node(12);
        Node d = new Node(17);
        Node e = new Node(19);

        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = e;
        e.prev = d;

        head = a;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target sum :");
        int target = sc.nextInt();
        twinSum(target);
    }
}

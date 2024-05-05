package Trees_BST;
/*
Leetcode:109
convert a sorted list to a BST:

    Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
height-balanced  binary search tree.

Example 1:
Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.

Example 2:
Input: head = []
Output: []
 */

public class BST09_conversion2 {
    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public static class LNode{

        int data;
        LNode next;
        LNode(int data){
            this.data = data;
        }
    }
    public Node sortedListToBst(LNode head){
        //calculate length of Linked list;
        int n = 0;
        LNode temp = head;
        while(temp!=null){
            n++;
            temp = temp.next;
        }

        // insertion   of elements of linked list in array
        int i=0;
        int [] arr = new int[n];
        while(temp !=null){
            arr[i++] = temp.data;
            temp = temp.next;
        }
        return conversion(arr,0,n-1);
    }
    public Node conversion(int[] arr, int lo, int hi){
        int mid = (lo+hi)/2;
        if(lo>hi) return  null;
        Node root = new Node(arr[mid]);
        root.left = conversion(arr,lo,mid-1);
        root.right= conversion(arr,mid+1,hi);
        return root;
    }
}

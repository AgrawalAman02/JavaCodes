package Trees_BST;
/*
Leetcode:701 ::: Insert in a BST;
You are given the root node of a binary search tree (BST) and
a value to insert into the tree. Return the root node of the BST after the insertion.
It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
You can return any of them.
 */
public class BST02_Insertion {
    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public Node insert(Node root, int target){
        if(root== null) return new Node(target);
        if(root.val>target) { // left side
            if(root.left == null) root.left = new Node(target);
            else insert(root.left,target);
        } else{
            if(root.right== null) root.right = new Node(target);
            else insert(root.right,target);
        }
        return root;
    }
}

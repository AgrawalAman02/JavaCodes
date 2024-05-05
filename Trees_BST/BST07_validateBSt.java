package Trees_BST;
/*
LeetCode : 99;
  Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

=====>>>  if the inorder traversal of the tree is sorted then this tree is surely BST;

 */
public class BST07_validateBSt {



    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    static boolean flag = true;
    static Node prev = null;
    public static void inorder(Node root){
        inorder(root.left);
        if(root== null) prev = root;
        else if(root.val<= prev.val){
            flag = false;
        } else{
            prev = root;
        }
        inorder(root.right);
    }
    public static boolean isValid(Node root){
        flag = true;
        prev = null;

        inorder(root);
        return flag;
    }
}

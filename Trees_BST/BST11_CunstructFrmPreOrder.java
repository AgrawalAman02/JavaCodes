package Trees_BST;
/*
Leetcode :1008
Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree),
construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val,
and any descendant of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
 */
public class BST11_CunstructFrmPreOrder {
    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }

    public Node insert(Node root, int target) {
        if (root == null) return new Node(target);
        if (root.val > target) { // left side
            if (root.left == null) root.left = new Node(target);
            else insert(root.left, target);
        } else {
            if (root.right == null) root.right = new Node(target);
            else insert(root.right, target);
        }
        return root;
    }

    public Node convertBst(int[] preorder) {
        Node root = new Node(preorder[0]);
//        return helper(preorder, 0, preorder.length);   // this one is my approach but the insertion function usage is raghav approach both are correct
        for(int i =1;i<preorder.length;i++){
            root = insert(root,preorder[i]);
        }
        return root;


    }


    private Node helper(int[] preorder, int lo, int hi) {
        if(lo>hi) return null;
        Node root = new Node(preorder[lo]);
        int i = 0;
        int idx = 0;
        for (i = lo; i < hi+1; i++) {
            if (preorder[i] > preorder[0]) {
                idx = i;
                break;
            }
        }
        root.left= helper(preorder,lo+1,idx-1);
        root.right= helper(preorder,idx,hi);
        return root;
    }
}
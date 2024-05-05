package Trees_BST;
/*
leetcode700 : Search in a BST
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and
return the subtree rooted with that node. If such a node does not exist, return null.
 */
public class  BST01_SearchBst {
    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public Node searchBST(Node root,int val){
        if(root== null ) return null;
        if(root.val  == val) return root;
        else if(root.val>val) return searchBST(root.left,val);
        else return searchBST(root.right,val);
    }
}

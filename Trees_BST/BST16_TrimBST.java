package Trees_BST;
/*
Leetcode 669;
Trim a Bst:
    Given the root of a binary search tree and the lowest and highest boundaries as low and high,
    trim the tree so that all its elements lies in [low, high].
    Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant).
    It can be proven that there is a unique answer.

Return the root of the trimmed binary search tree.
Note that the root may change depending on the given bounds.

Example 1:
Input: root = [1,0,2], low = 1, high = 2
Output: [1,null,2]
Example 2:
Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
Output: [3,2,null,1]
 */
public class BST16_TrimBST {
    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public void helper(Node root, int lo, int hi){
        if(root== null) return;
        while(root.left!= null){
            if(root.left.val<lo) root.left = root.left.right;
            else if(root.left.val>hi) root.left = root.left.left;
            else break;
        }
        while(root.right != null){
            if( root.right.val > hi) root.right = root.right.left;
            else if(root.right.val <lo) root.right = root.right.right;
            else break;
        }

        helper(root.left,lo, hi);
        helper(root.right, lo,hi);

    }
    public Node trim(Node root, int low , int high){
        Node parent = new Node(Integer.MAX_VALUE);
        parent.left = root;
        helper(parent,low,high);
        return parent.left;
    }

}

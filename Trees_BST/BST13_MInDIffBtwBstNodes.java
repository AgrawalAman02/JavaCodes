package Trees_BST;
/*
Leetcode:783
Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1
Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1

so we have to find the difference btw all the node and check whether that wiil be min or not
so are we going to do so?
obviously NO!
if we sort it then we find the diff btw the consecutive node then it will take lesss time . then no need to find all the diff
as min diff is btw the consecutive in  sorted order
so we do inorder traversal where we got the sorted traversal and maintain a min var. and prev. var AND store the value of prev in prev and diff in min by comparing it
....................
 */
public class BST13_MInDIffBtwBstNodes {
    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public static int min = Integer.MAX_VALUE;
    public static Node prev = null;

    public int minDiffInBst(Node root){
        if(root== null) return 0;
        minDiffInBst(root.left);
        if(prev!=null) {   /// checking for the first case i.e. during first it is null

            if (Math.abs(root.val - prev.val) < min) min = Math.abs(root.val - prev.val);
        }
        prev = root;
        minDiffInBst(root.right);
        return min;


    }
}

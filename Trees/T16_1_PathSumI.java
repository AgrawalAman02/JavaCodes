package Trees;
/*
LeetCode 112
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:
Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 */

public class T16_1_PathSumI {
    public static class Node {
                int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public boolean hasPathsumI(Node root, int targetSum ){
        if(root == null) return false;
        if(root!= null && root.left==null&& root.right == null){
            if(root.val== targetSum) return true;
        }
        return hasPathsumI(root.left,targetSum-root.val) ||  hasPathsumI(root.right,targetSum-root.val);
    }
}

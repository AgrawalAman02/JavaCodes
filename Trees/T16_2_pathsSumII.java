package Trees;
import java.util.*;
/*
leetCode : 113
Given the root of a binary tree and an integer targetSum,
return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: []

Example 3:
Input: root = [1,2], targetSum = 0
Output: []


 */
public class T16_2_pathsSumII {
    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> pathSum(Node root, int targetSum){
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        helper(ans,arr, root, targetSum);
        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer> arr, Node root, int targetSum) {
        if(root== null) return;
        if(root.left== null && root.right== null) {
            arr.add(root.val);
            if(root.val== targetSum) {
                List<Integer> a = new ArrayList<>();
                for (int i = 0; i < arr.size(); i++) {
                    a.add(arr.get(i));
                }
                ans.add(a);
            }
            arr.remove(arr.size()-1);  // backtracking
        }
        arr.add(root.val);
        helper(ans,arr, root.left, targetSum- root.val);
        helper(ans,arr, root.right, targetSum- root.val);
        arr.remove(arr.size()-1);   // backtracking
    }

}

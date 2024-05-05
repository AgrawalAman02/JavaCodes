package Trees_BST;
/*
LeetCode 108:
   Convert a sorted array into Bst:
    Given an integer array nums where the elements are sorted in ascending order, convert it to a
height-balanced binary search tree

=> we can do it by binary search recursively ehere mid will always the root node;
 */
public class BST08_conversion {
    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public Node helper(int[] nums, int lo, int hi){
        if(lo>hi) return null;
        int mid = (lo+hi)/2;
        Node root = new Node(nums[mid]);
        root.left = helper(nums, lo,mid-1);
        root.right= helper(nums, mid +1, hi);
        return root;

    }
    public Node conversion(int[] nums){
        int n = nums.length;
        return helper(nums, 0 , n-1);
    }
}

package Trees;
import java.util.*;
/*
Given the root of a binary tree , return all root-to-leaf paths in any order.

A leaf is a node with no children.
Input: root = [1,2,3,null.5]
Output: ["1->2->5","1->3"]
 */
public class T08_BinaryTreePaths {
    class solution{
        public static class Node {
            int val;    // initially 0
            Node left;  // null
            Node right; // null

            public Node(int val) {
                this.val = val;
            }
        }

        public static void helper(Node root,List<String> ans, String s){
            if(root==null) return;
            if(root.left==null && root.right== null){
                s+=root.val;
                ans.add(s);
                return;
            }
            helper(root.left,ans,s+root.val+"->");
            helper(root.right,ans,s+root.val+"->");
        }
        public static List<String> binaryTreePaths(Node root){
            List<String> ans = new ArrayList<>();
            helper(root,ans,"");
            return ans;
        }

    }

}

package Trees;

import com.sun.source.tree.Tree;

/*
for getting O(1) space comp
by MORRIS TRAVERSAL
    - iterative traversal.
 */
public class T17_flatten_optimised {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static class solution{             // static because if it being called from static method i.e. main method
        public void flattenOP(TreeNode root){
            TreeNode curr = root;
            while(curr!= null){
                while(curr.left!= null){
                    TreeNode pred = curr.left;
                    while(pred.right!= null) pred = pred.right;
                    pred.right = curr.right;
                    curr.right= curr.left;
                    curr.left = null;
                }
                curr = curr.right;

            }
        }

    }
}

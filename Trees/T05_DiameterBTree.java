package Trees;
/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
 */
public class T05_DiameterBTree {
    public static class Node{
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }

    public static int height(Node root){
        if(root== null || (root.left== null && root.right== null)){
            return 0;
        }
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public static int diameterOfBinarytree(Node root){
        if(root== null || (root.left== null && root.right== null)){
            return 0;
        }
        int leftAns = diameterOfBinarytree(root.left);
        int rightAns = diameterOfBinarytree(root.right);
        int mid = height(root.left) +height(root.right);
        if(root.right!= null) mid++;
        if(root.left!= null) mid++;
        int max  = Math.max(leftAns, Math.max(rightAns,mid));
        return max;

    }
    public static void main(String[] args) {

    }
}

package Trees;
// A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than 1

public class T06_HeightBalancedBTree {

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
    public static boolean isBalanced(Node root){
        if(root== null ) return true;
        int lh= height(root.left);
        if(root.left != null) lh++;   // for skewed tree
        int rh  = height(root.right);
        if(root.right != null) rh++;  // for skewed tree 
        int d = lh- rh;
        if(d<0) d = -d;
        if(d>1) return false;
        return (isBalanced(root.left) && isBalanced(root.right));
    }
}

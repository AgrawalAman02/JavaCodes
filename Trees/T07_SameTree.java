package Trees;
/*
Giiven the roots of the two binary trees p and q , write a function to check if they are the same root or not.
Two binary trees are considered the same if they are structurally identical , and the nodes have hte same value.
 */
class solution{
    public static class Node{
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public static boolean isSameTree(Node p , Node q){
        if(p==null && q== null) return true;
        if(p==null || q== null) return false;  // very imp
        if(p.val != q.val) return false;
        return isSameTree(p.left , q.left) && isSameTree(p.right,q.right);
    }

}

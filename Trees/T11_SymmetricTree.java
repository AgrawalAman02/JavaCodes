package Trees;
/*
(L.C. 101)- Given a root of a binary tree , check whether it is mirror of itself or not, (i.e. symmetric about its centre)
 */
public class T11_SymmetricTree {
    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public static boolean isSame(Node p , Node q){  // this function is enough for checking symmetry or not
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if (p.val!= q.val) return false;
        return isSame(p.left,q.right)&&isSame(p.right,q.left);
    }
    public static Node inverttree(Node root){
        if(root== null ) return root;
        Node l = root.left;
        Node r = root.right;
        root.left = inverttree(r);
        root.right = inverttree(l);
        return root;
    }
    public static boolean isSameTree(Node p , Node q){   // for Raghav Approach
        if(p==null && q== null) return true;
        if(p==null || q== null) return false;  // very imp
        if(p.val != q.val) return false;
        return isSameTree(p.left , q.left) && isSameTree(p.right,q.right);
    }
    public static boolean isSymmetric(Node root){
        if(isSame(root.left,root.right)) return true;
        else return false;
        /*
        //or we can do by raghav dA METHod i.e. we first invert the left child and
        check whether left inverted child and right original child is same or not by original isSame tree method of comapring two trees
        if(root== null)n return true;
        root.left = inverttree(root.left);
        return isSametree(root.left,root.right);

        // bs ho gya , khatam TATA BYE BYE!
        // itna hi!

         */
    }
    public static void main(String[] args) {

    }
}

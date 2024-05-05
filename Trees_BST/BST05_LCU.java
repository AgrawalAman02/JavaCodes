package Trees_BST;
/*
Leetcode 235 :
same question we solve in BT
but thats time complexity is O(n)
but we do in O(logn) here
 */
public class BST05_LCU {
    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public static Node LCU(Node root, Node p, Node q){
        if(p.val == root.val || q.val == root.val) return root;
        else if(p.val<root.val && q.val >root.val) return  root;
        else if(p.val>root.val && q.val <root.val) return  root;
        else if(p.val<root.val && q.val<root.val) return  LCU(root.left,p,q);
        else return LCU(root.right, p,q);

        // or we can do so in three lines as first 3 cases have return root
        /*
        if(p.val<root.val && q.val<root.val) return  LCU(root.left,p,q);
        else if(p.val>root.val && q.val>root.val) return LCU(root.right, p,q);
        else return  root;
        */
    }
}

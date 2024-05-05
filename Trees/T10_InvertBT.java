package Trees;
// Given the root of a binary tree, invert the tree, and return its root;    (LC = 256)
public class T10_InvertBT {
    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public static Node inversion(Node root){
        if(root== null) return root;
        Node temp = root.left;
        root.left= root.right;
        root.right= temp;
        inversion(root.left);
        inversion(root.right);
        /*
        or we can write :
            Node l = root.left;
            Node r = root.right;
            root.left = inversion(r);
            root.right = inversion(l);
            this is also a good way that is used is various question
         */

        return root;
    }
    public static void display(Node root){
        if(root == null) return;
        System.out.print(root.val + " -> ");
        if(root.left!= null) System.out.print(root.left.val + " , "); else System.out.print("null, ");
        if(root.right!= null) System.out.print(root.right.val + "."); else System.out.print("null.");
        System.out.println();
        display(root.left);
        display(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
//        root.val = 1;
//        System.out.println(root.val);
        Node a = new Node(2);
        Node b = new Node(6);
        root.left = a;
        root.right = b;
        Node c = new Node(5);
        Node d = new Node(10);
        a.left = c;
        a.right = d;
        Node e = new Node(11);
        b.right = e;
        display(root);
        inversion(root);
        display(root);
/*
t.c = O(n)
s.c = O(h) h = height
 */
    }
}

package Trees;
/*
-----------------------------------------*VeryFamous*---------------------------------(Leetcode236)
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1

Constraints:

The number of nodes in the tree is in the range [2, 10^5].
-10^9 <= Node.val <= 10^9
All Node.val are unique.
p != q
p and q will exist in the tree.

===>>>>>  we can solve it by using node-to-root path where the node that is commom in both the path is the LCA
Or, below:
 */
public class T09_LowestCommonAncestor {
    public static class Node {
            int val;    // initially 0
            Node left;  // null
            Node right; // null

            public Node(int val) {
                this.val = val;
            }
    }
    public static boolean isContains(Node root, Node node){
        if(root == null ) return false;
        if(node == root) return true;
        return (isContains(root.left, node) || isContains(root.right, node));
    }
    public static Node LCU(Node root, Node p ,Node q){
        if(p==root|| q== root) return root;
        if(p==q) return p;
        boolean Leftp = isContains(root.left,p);
        boolean Rightq = isContains(root.right,q);
        if((Leftp && Rightq) || (!Leftp && !Rightq)) return root;
        if(!Leftp && Rightq) return LCU(root.right,p,q);
        if(Leftp && !Rightq) return  LCU(root.left,p,q);
        return root;  // jut for function type;
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
        System.out.println(LCU(root,b,a).val);
    }
}

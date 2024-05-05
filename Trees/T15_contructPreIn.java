package Trees;
/*
lc -
Given two integer arrays preorder and inorder
where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree,
construct and return the binary tree.
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 */
public class T15_contructPreIn {

    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public Node buildTree(int[] preorder, int[] inorder){
        int n= preorder.length;
        return helper(preorder, 0 , n-1, inorder, 0 , n-1);
    }

    private Node helper(int[] preorder, int prelo, int prehi, int[] inorder, int inlo, int inhi) {
        if(prelo>prehi) return null;
        Node root = new Node(preorder[prelo]);
        int i = inlo;
        while(inorder[i]!=preorder[prelo])  i++;
        int ls = i - inlo;  // ls = left size
        root.left = helper(preorder, prelo, prelo+ls,inorder,inlo, i-1);
        root.right = helper(preorder,prelo+ls+1,prehi,inorder,i+1,inhi);
        return root;
        /*
        t.c :
        best = O(nlog(n))
        worst = O(n.h)

        s.c = O(2^h)
         */

    }
}

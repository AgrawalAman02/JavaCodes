package Trees_BST;
/*
we have to do inorder by the help of morris algorithm
    we can also do it by stack but mehenga h bbhai
    the inorder traversal question is available in leetcode where we can do by any way
    LeetCode :94:
        Given the root of a binary tree, return the inorder traversal of its nodes' values in a list .

 */
import java.util.*;

public class BST14_MorrisAlgorithm {
    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public List<Integer> inorderTrav(Node root){
        Node curr = root;
        List<Integer> arr = new ArrayList<>();
        while(curr!= null){
            if(curr.left!= null){
                Node pred = curr.left;
                while(pred.right!= null){
                    pred = pred .right;

                }
                if(pred.right!= null && pred.right != curr) {
                    pred .right = curr;
                    curr = curr.left;
                } else{
                    pred.right = null;
                    arr.add(curr.val);
                    curr = curr.right;
                }
            } else{
                arr.add(curr.val);
                curr = curr.right;
            }

        }
        return  arr;

    }
}

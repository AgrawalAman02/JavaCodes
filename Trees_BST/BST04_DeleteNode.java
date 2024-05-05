package Trees_BST;
import java.util.*;

// LeetCode 450;
public class BST04_DeleteNode {
    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public static int height(Node root){   // this height is defined in next file T02
        if(root == null || (root.left== null && root.right == null)) return 0;
        return 1+  Math.max(height(root.left),height(root.right));
    }
    public static Node constructBfs(String[] arr){
        int x = Integer.parseInt(arr[0]);  // parse is use to cnvert string to int directly
        int n = arr.length;
        Node root = new Node(x);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(i<n-1){
            Node temp = q.remove();
            Node left = new Node(10); // u can take any value here as we r just initialising it as we r going to chnage it later ;
            Node right = new Node(100000);
            if(arr[i].equals("")) left = null;
            else{
                left.val = Integer.parseInt(arr[i]);
                q.add(left);
            }
            if(arr[i+1].equals("")) right = null;
            else{
                right.val = Integer.parseInt(arr[i+1]);
                q.add(right);
            }
            temp.left = left;
            temp.right = right;
            i+=2;
        }
        return root;
    }
    public static void main(String[] args) {
        String[] arr = {"50","20","60","17","34","55","89","10","","28","","","","70","","","14"};
        Node root = constructBfs(arr);
        preorder(root);
        System.out.println();
        deleteNode(root,14);   // for leaf node
        preorder(root);
        System.out.println();
        deleteNode(root,50);   // for 1 child
        preorder(root);
        System.out.println("not able to prinnt 50 see video again basic question BST");
        /*
        for deleting node having 2 child we can have two option
             after deleting we can replace it with two node:
                 1st : inorder predecessor (extreme right child of first left child of that node as we had seen in morris algo)
                 or, 2nd : inorder successor(extreme left child of first right child of that node)
         */
        
    }
    // for leetcode below is the function to pass a testcase having deletion of single root node
    public static Node deleteNode(Node root, int target){
        Node temp = new Node(Integer.MAX_VALUE);
        temp.left = root;
        delete(temp,target);
        root= temp.left;
        return root;
    }

    private static void delete(Node root, int target) {
        if(root == null) return;
        if(root.val>target) {
            if(root.left== null) return;
            if(root.left.val== target) {
                if(root.left.left== null && root.left.right== null) root.left = null;    // fpr leaf node
                else if(root.left.left== null || root.left.right== null) {               // for 1 child case
                    if(root.left.left == null) root.left = root.left.right;
                    else root.left = root.left.left;
                } else{             // two child
                    Node l = root.left;
                    Node curr = l;
                    Node pred = curr.left;
                    while(pred.right!= null) pred  = pred.right;  // for getting extreme end
                    delete(root,pred.val);
                    pred.left = curr.left;
                    pred.right = curr.right;
                    root.left = pred;

                }
            }
            else delete(root.left, target);
        } else{
            if(root.right== null) return;
            Node r = root.right;

            if(root.right.val== target){
                if(r.left== null&& r.right  == null)root.right = null;  // for 1 child
                else if(r.left== null || r.right  == null){
                    if(r.left!= null) root.right= r.left;
                    else root.right = r.right;

                }
                else{
                    Node curr = r;
                    Node pred = curr.right;
                    while(pred.right!= null) pred  = pred.right;  // for getting extreme end
                    delete(root,pred.val);
                    pred.left = curr.left;
                    pred.right = curr.right;
                    root.right = pred;
                }
            }
            else delete(root.right, target);
        }

    }


    public static void preorder(Node root){
        if(root == null ) return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);

    }
// dont understood see others video or chatgpt leetcode 450

}

package Trees_BST;
import java.util.*;

public class BST03_Traversal {
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
        String[] arr = {"10","5","15","2","8","12","17"};
        Node root = constructBfs(arr);
        preorder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        inorder(root);
    }
    public static void preorder(Node root){
        if(root == null ) return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);

    }

    public static void inorder(Node root){
        if(root == null ) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    public static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
}

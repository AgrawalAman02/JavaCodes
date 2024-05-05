package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class T12_ConstructTree {
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
    public static void nthLevel(Node root, int n){   // left to right traversal
        // since we have to print all element of nth level of the tree, we when that level is passed then we take that variable
        // and decereased to 1 on each calling (recursion)
        // the that parameter value = 1 then we reached that level so print htat value
        if(root == null ) return;
        if(n==1){
            System.out.print(root.val +" ");
            return;
        }
        nthLevel(root.left,n-1);
        nthLevel(root.right,n-1);
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
        String[] arr = {"1","2","3","90","4","5","","6","","7","","","8","","","","9",""};
        Node root = constructBfs(arr);
        int level = height(root) +1;
        for(int i = 1;i<=level;i++){
            nthLevel(root,i);
            System.out.println();
        }
    }
}

package Trees;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a  binary tree , print boundary nodes of the Binary tree anti-clockwise starting from the root

ans - so print alll the left boundary
all leaf nodes '(excluding leaf)
all right boundaries   (excluding leaf)  in reverse order
 */
public class T13_Boundarytraversal {
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
        // since we have to print all element of nth level of the tree, we when that level is passed then we take that variable and decereased to 1 on each calling (recursion)
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
        String[] arr = {"1","2","3","4","5","","6","7","","8","","9","10","","11","","12","","13","","14","15","16","","17","","","18","","19","","","","20","21","22","23","","24","25","26","27","","","28","",""};
        Node root = constructBfs(arr);
//        int level = height(root) +1;
//        for(int i = 1;i<=level;i++){
//            nthLevel(root,i);
//            System.out.println();
//        }
        boundaryDisplay(root);
    }
    //boundary printing below
    public static void boundaryDisplay(Node root){
        leftBoundary(root);  // here root is also printed as root is passed
//        System.out.println(); // to distinguish left right and tail
        bottomDispaly(root);
//        System.out.println(); // to distinguish left right and tail
        rightBoundary(root.right);  // as root is printed once so right is passed here
    }

    private static void rightBoundary(Node root) {
        if(root== null ) return;
        if(root.left== null && root.right== null) return;
//        System.out.print(root.val + " "); // as here we are printing then it will print in original order but when we print after call it print in reverse order i.e in backtracking
        if(root.right!= null) rightBoundary(root.right);
        else rightBoundary(root.left);
        System.out.print(root.val + " ");

    }

    private static void bottomDispaly(Node root) {
        if(root== null ) return;
        if(root.left== null && root.right == null){
            System.out.print(root.val + " ");
            return;
        }
        bottomDispaly(root.left);
        bottomDispaly(root.right);
    }

    private static void leftBoundary(Node root) {
        if(root== null ) return ;
        if(root.left== null && root.right== null) return;
        System.out.print(root.val + " ");
        if(root.left!= null) leftBoundary(root.left);
        else leftBoundary(root.right);
    }
}

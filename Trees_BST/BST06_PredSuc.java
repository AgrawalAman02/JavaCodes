package Trees_BST;
import java.util.*;
//find the immediate inorder predessor and successor of the node
public class BST06_PredSuc {
    static int pred = -1;
    static int suc = -1;
    static  Node temp = null;
    static boolean flag = false;

    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
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
    public static void inorder(Node root,int val){
        if(root == null ) return;
        inorder(root.left,val);
//        System.out.print(root.val+" ");
        if(temp == null) temp = root;
        else{
            if(root.val==val) {
                pred = temp.val;
                flag = true;
            }else if(root.val>val && flag == true){
                suc = root.val;
                flag = false;
            }
            else{
                temp = root;
            }
        }
        inorder(root.right,val);


    }

    public static void main(String[] args) {
        String[] a = {"50", "30", "70","20","40","60","80"};
        Node root = constructBfs(a);
        int val =70;
        inorder(root,val);
        System.out.println(pred);
        System.out.println(suc);

    }

}

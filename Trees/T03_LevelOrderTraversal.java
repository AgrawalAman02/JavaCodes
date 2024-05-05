package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class T03_LevelOrderTraversal {

    public static class Node{
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }

    /////////////////////////////////////////------------BFS-BREADTH FIRST SEARCH-------------//////////////////////////////////////////////

    public static void bfs(Node root){  // iterative
        Queue<Node> q = new LinkedList<>();
        if(root!= null) q.add(root);
        while(q.size()>0){
            Node temp = q.peek();
            if(temp.left!= null) q.add(temp.left);
            if(temp.right!= null) q.add(temp.right);
            System.out.print(q.remove().val+" ");
            
        }
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
        // for level order traversal or to prit hte element level wise , use bfs
        bfs(root);
    }
}

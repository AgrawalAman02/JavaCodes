package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

////////////////////////////////////////------------------------DFS-DEPTH FIRST SEARCH---------------------------////////////////////////////////////////////////////
public class T04_DFS {
    public static class Node{
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public static List<Integer> dfs(Node root){
        List<Integer> arr = new ArrayList<>();
        if(root== null ) return arr;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(st.size()>0){
            Node temp = st.peek();
            if(temp.left!= null) {
                st.push(temp.left);
                temp.left = null;
            } else{
                st.pop();
                arr.add(temp.val);
                if(temp.right!= null ) st.push(temp.right);
            }
        } return arr;
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
        System.out.println(dfs(root));
    }
}

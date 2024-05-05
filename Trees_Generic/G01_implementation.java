package Trees_Generic;
import java.util.*;

public class G01_implementation {
    public static class Node{
        int val;
        List<Node> child;
        public Node(int val){
            this.val = val;
            child = new ArrayList<>();
        }
    }

    public static void formTree(Node root){
        root.child.add(new Node(5));// 30-5
        root.child.add(new Node(11));//30-5,11
        root.child.add(new Node(63));// 30-5,11,63
        root.child.get(0).child.add(new Node(1));  // 30 - 5(-1),11,63
        root.child.get(0).child.add(new Node(4)); // 30 - 5(- 1,4),11,63
        root.child.get(0).child.add(new Node(8)); // 30 - 5(- 1,4,8),11,63
        root.child.get(0).child.add(new Node(4)); // 30 - 5(- 1,4,8,4),11,63
        root.child.get(1).child.add(new Node(6)); // 30 - 5(- 1,4,8,4),11(- 6),63
        root.child.get(1).child.add(new Node(7)); // 30 - 5(- 1,4,8,4)),11(- 6,7),63
        root.child.get(1).child.add(new Node(15)); // 30 - 5(- 1,4,8,4),11(- 6,7,15),63
        root.child.get(2).child.add(new Node(31)); // 30 - 5(- 1,4,8,4),11(- 6,7,15),63(- 31)
        root.child.get(2).child.add(new Node(55)); // 30 - 5(- 1,4,8,4)),11(- 6,7,15),63(- 31,55)
    }
    public static void preOrder(Node root){
        if(root.child.isEmpty()){
            System.out.print(root.val+" ");
            return;
        }
        System.out.print(root.val+" ");
        int n = root.child.size();
        for(int i = 0; i<n;i++){
            preOrder(root.child.get(i));
        }
    }
    public static void postOrder(Node root){
        if(root.child.isEmpty()){
            System.out.print(root.val+" ");
            return;
        }

        int n = root.child.size();
        for(int i = 0; i<n;i++){
            postOrder(root.child.get(i));
        }
        System.out.print(root.val+" ");
    }

    public static  void levelORderTrav(Node root){
        Queue<Node> q  = new LinkedList<>();
        q.add( root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            System.out.print(temp.val + " ");
            int noOfChild = temp.child.size();
            for (int i = 0; i < noOfChild; i++) {
                q.add(temp.child.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(30);   // 30
        formTree(root);
        // dfs - pre post (in is here not easily possible)
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        // bfs (level order)
        // using queue
        levelORderTrav(root);
        // we can also do zig zag traversal using post in even case
    }
}

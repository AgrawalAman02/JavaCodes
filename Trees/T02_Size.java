package Trees;
/*
Learn,
    Size of root : size  of (root.left) + size of (root.right) + 1 (i.e. +1  for the root itself)

 */
public class T02_Size {
    public static class Node{
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }

    public static int size(Node root){
        if(root == null) return 0;
        return 1 +size(root.left) + size(root.right);
    }

//    Total sum of value  of each node = val of that node + value of left nodes + value of right nodes;
    public static int sumOfNodes(Node root){
        if(root==null ) return 0;
        return root.val + sumOfNodes(root.left)+ sumOfNodes(root.right);

    }

    public static int max(Node root){
        // max tree = max[ (root.val ), max(root.left) , max(root.right)]
        if(root == null) return Integer.MIN_VALUE;  // taking consideration of the negaative value in the tree i.e. 0 is always greater than negative val of root.val so fx never return negative
        else return Math.max(root.val ,Math.max(max(root.left),max(root.right)  /* -- this max are function max for recursive call */  ));

    }

    public static int height(Node root){
        // height (tree) = 1+ max(height(root.left) ,height(root.right));  +1 for the first descendants from root/ parent node
//        if(root == null) return 0 ;   if we give this as condition only then it will give 1 as the height of terminal node as height is 1 + 0 (root.left is null so height returned as 0 for that) + 0 = 1 != 0
        if(root == null || (root.left== null && root.right == null)) return 0;  // so we do this as a check for leaf node
        return 1+ Math.max(height(root.left), height(root.right));
    }

    public static int min(Node root){
        if(root== null) return Integer.MAX_VALUE;
        else return Math.min(root.val,Math.min(min(root.left),min(root.right)));
    }

    public static int productNodes(Node root){
        if(root == null ) return 1;
        return root.val*productNodes(root.left)*productNodes(root.right);
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
        System.out.println(size(root));
        System.out.println(sumOfNodes(root));
        System.out.println(max(root));
        System.out.println(height(root));
        System.out.println(min(root));
        System.out.println(productNodes(root));
    }
}

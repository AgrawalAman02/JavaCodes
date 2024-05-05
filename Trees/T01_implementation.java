package Trees;

public class T01_implementation {
    static int count = 0;
    public static class Node{
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public static void preorder(Node root){
        if(root == null ) return;
        System.out.println(root.val);
        count ++;
        preorder(root.left);
        preorder(root.right);

    }

    public static void inorder(Node root){
        if(root == null ) return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public static void nthLevel(Node root, int n){
        // left to right traversal
        // since we have to print all element of nth level of the tree, we when that level is passed then we take that variable and  decreased to 1 on each calling (recursion)
        // the that parameter value = 1 then we reached that level so print that value
        if(root == null ) return;
        if(n==1){
            System.out.print(root.val +" ");
            return;
        }
        nthLevel(root.left,n-1);
        nthLevel(root.right,n-1);
    }
    public static void nthLevelRL(Node root, int n){   // right to left traversal
        // since we have to print all element of nth level of the tree, we when that level is passed then we take that variable and decereased to 1 on each calling (recursion)
        // the that parameter value = 1 then we reached that level so print htat value
        if(root == null ) return;
        if(n==1){
            System.out.print(root.val +" ");
            return;
        }
        nthLevelRL(root.right,n-1);
        nthLevelRL(root.left,n-1);
    }
    public static void display(Node root){
        if(root == null) return;
        System.out.print(root.val + " -> ");
        if(root.left!= null) System.out.print(root.left.val + " , "); else System.out.print("null, ");
        if(root.right!= null) System.out.print(root.right.val + "."); else System.out.print("null.");
        System.out.println();
        display(root.left);
        display(root.right);
    }

    public static int height(Node root){   // this height is defined in next file T02
        if(root == null || (root.left== null && root.right == null)) return 0;
        return 1+  Math.max(height(root.left),height(root.right));
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
        display(root);  // we will see that the display print in preorder manner
        // so we should see how preorder prints by making a function preorder
        preorder(root);
        System.out.println("the count is : "+ count);
        System.out.println("the inorder");
        inorder(root);
        System.out.println("\"(the postorder)\"");
        postOrder(root);
        System.out.println("the nth level is ");
        nthLevel(root,2);   // here n is the level
        // to print all the level we can use the for loop upto the total no. of levels of tree which is 1 greater than the height of the tree
        int level = height(root) +1;
        System.out.println("\nall the levels are");
        for(int i = 1;i<=level;i++){
            nthLevel(root,i);
            System.out.println();
        }
        System.out.println("\n For the Zig-Zag traversal : ");  // L.C. 103
        for(int i = 1;i<=level;i++){
            if(i%2==0)
            nthLevelRL(root,i);
            else nthLevel(root,i);
            System.out.println();
        }
    }
}

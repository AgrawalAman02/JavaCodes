package Trees;

import java.util.*;

public class T14_s_LeftSideView {
        public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public static int height(Node root){
        if(root== null || (root.left== null && root.right== null)){
            return 0;
        }
        return 1 + Math.max(height(root.left),height(root.right));
    }
    private void preOreder(Node root, List<Integer> ans, int level) {
        if(root== null) return ;
        ans.set(level-1,root.val);

        preOreder(root.right,ans,level+1);
        preOreder(root.left,ans,level+1);
    }
    public List<Integer> leftSideView(Node root){
        List <Integer> ans = new ArrayList<>();
        if(root == null ) return ans;
        int level = height(root) +1;
        for(int i = 0 ; i<level;i++){
            ans.add(100);       // to add any random element on each position of the array
        }
        preOreder(root,ans,1);
        return ans;
    }

}

package Trees;

import java.util.ArrayList;
import java.util.List;

/*
-> L.C. 199 . Binary tree right side view

Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]

=>
there is one way of solving it , i.e.
during level order traversal, we get a list of list containing elements of each level in one list
so if we print the last element of each level that will the element we get on right side view as we got only the last element f each level
similarly if we print the first element we get the left side view

but we are doing below in other way
 */
public class T14_RightView {
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
        preOreder(root.left,ans,level+1);
        preOreder(root.right,ans,level+1);
    }
    public List<Integer> rightSideView(Node root){
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

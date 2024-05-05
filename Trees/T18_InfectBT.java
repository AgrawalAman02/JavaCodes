package Trees;

import java.util.*;

/*
Leetcode : 2385
Amount of time for a binary tree to be infected/ completely burn;

You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.

Each minute, a node becomes infected if:

    The node is currently uninfected.
    The node is adjacent to an infected node.
Return the number of minutes needed for the entire tree to be infected.

Input: root = [1,5,3,null,4,10,6,9,2], start = 3
Output: 4
Explanation: The following nodes are infected during:
- Minute 0: Node 3
- Minute 1: Nodes 1, 10 and 6
- Minute 2: Node 5
- Minute 3: Node 4
- Minute 4: Nodes 9 and 2
It takes 4 minutes for the whole tree to be infected so we return 4.
 Example 2:


Input: root = [1], start = 1
Output: 0
Explanation: At minute 0, the only node in the tree is infected so we return 0.
*/
public class T18_InfectBT {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public class solution{
        public TreeNode getNode(TreeNode root, int start){
            if(root== null) return null;
            if(root.val == start ) return root;
            TreeNode left = getNode(root.left, start);
            TreeNode right = getNode(root.right,start);
            if(left == null ) return  right;
            else return left;
        }
        public void preorder(TreeNode root, Map<TreeNode, TreeNode> p){
            if(root== null ) return;
            if(root.left != null) p.put(root.left,root);
            if(root.right!= null) p.put(root.right,root);
            preorder(root.left,p);
            preorder(root.right,p);
        }
        public int amountOfTime(TreeNode root, int start){
            TreeNode node = getNode(root,start);
            Map <TreeNode, TreeNode> p = new HashMap<>();
            preorder(root,p);
            // bfs
            Queue<TreeNode> q = new LinkedList<>();
            q.add(node);
            Map<TreeNode,Integer> v = new HashMap<>();
            v.put(node,0);

            while(q.size()>0){
                TreeNode temp = q.peek();   // q.remove();
                int level = v.get(temp);
                if(temp.left!= null && !v.containsKey(temp.left)){
                    q.add(temp.left);
                    v.put(temp.left,level+1);
                }
                if(temp.right!= null && !v.containsKey(temp.right)){
                    q.add(temp.right);
                    v.put(temp.right,level+1);
                }
                if(p.containsKey(temp) && !v.containsKey(p.get(temp))){
                    q.add(p.get(temp));
                    v.put(p.get(temp),level+1);
                }
                q.remove();
            }
            int max = -1;
            for(int level : v.values()){
                max = Math.max(max,level);
            }
            return max;

        }
    }


}

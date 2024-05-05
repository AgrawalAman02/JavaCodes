package Trees_BST;
/*
Leetcode 1305:
All elements in two bst;
Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

Example 1:
Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:
Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]

 */
import java.util.*;
public class BST15_AllElementsin2BSt {
    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public void Morris(List<Integer> arr, Node curr){
        while(curr!= null){
            if(curr.left!= null){  // find pred
                Node pred = curr.left;
                while(pred.right!= null&&pred.right != curr) pred = pred.right;
                if(pred.right==null){  // connect pred to curr
                    pred.right = curr;
                    curr = curr.left;
                }
                if(pred.right == curr){   // unlink
                    pred.right = null;
                    arr.add(curr.val);
                    curr= curr.right;
                }
            } else {
                arr.add(curr.val);
                curr= curr.right;
            }
        }
    }
    public void merge(List<Integer> a,List<Integer> b ,List<Integer> ans){
        int i = 0,j=0;
        while(i<a.size()&&j<b.size()){
            if(a.get(i) <= b.get(j)){
                ans.add(a.get(i));
                i++;
            } else{
                ans.add(b.get(j));
                j++;
            }
        }
        if(i==a.size()){
            while(j<b.size()){
                ans.add(b.get(j));
                j++;
            }
        } else{
            while(i<a.size()){
                ans.add(a.get(j));
                i++;
            }
        }
    }
    public List<Integer> getElements(Node root1,Node root2){
        List<Integer> arr1 = new ArrayList<>();   // root1 ke saare elements ko add krne ke liye
        Morris(arr1,root1);
        List<Integer> arr2 = new ArrayList<>();
        Morris(arr2,root2);
        List<Integer> ans = new ArrayList<>();
        merge(arr1,arr2,ans);
        return ans;
    }
}

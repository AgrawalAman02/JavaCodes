package Trees;
/*
L.C. 437:
Given the root of a binary tree and an integer targetSum,
return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf,
but it must go downwards (i.e., traveling only from parent nodes to child nodes).

Example 1:
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
Example 2:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3

so difference between the pathsum2 and 3 is that here we not need only root to leaf , we can also take any node upto any node
so catch is that as we usually return after we got the target sum in the recsion, (here we make count == 2)
but here wu=e will not return , i.e. we will continue to do the operation i.e. reducing the value of targetv sum  and chrcking the value of it ;even after getting the atrget(now we increase the count by 1 if we got anoter sum)

now we checked it for root node , now we check it for every node by doing traversal
 */

public class T16_3_PathSumIII {
    public static class Node {
        int val;    // initially 0
        Node left;  // null
        Node right; // null

        public Node(int val) {
            this.val = val;
        }
    }
    public  int pathsum(Node root, int targetSum){
        if(root == null ) return 0;
        int count = 0;
        count = noOfPath(root, targetSum);
        count+= (pathsum(root.left,targetSum)+ pathsum(root.right,targetSum));
        return count;

    }

    public int noOfPath(Node root, int targetSum) {
        if(root == null ) return 0;
        int count= 0;
        if(root.val == targetSum) count++;
        return count + noOfPath(root.left, targetSum- root.val) + noOfPath(root.right,targetSum- root.val);
    }
}
// this will run in all cases except one when value exceeds the range of int
// so we typecast target sum and root . val
// t.c = O(n^2)    s.c = O(nh)-> 0(n^2) for skewed -> O(nlogn) for balanced

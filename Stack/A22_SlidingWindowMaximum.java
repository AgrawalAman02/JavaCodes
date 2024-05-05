package Stack;
/*
------------------------------------------------------------LeetCode---------------------------------------------------------------------------
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
 */
public class A22_SlidingWindowMaximum {
    static class Solution{
        public int[] maxWin_HighComplex(int[] nums,int k){
            int n = nums.length;
            // n - (k-1) = n-k+1;
            int [] ans = new int[n-k+1];
            int z = 0;
            for(int i = 0 ;i<n-k+1;i++){
                int max = Integer.MIN_VALUE;
                for(int j= i; j<i+k;j++){
                    max = Math.max(max,nums[j]);
                }
                ans[z++] = max;
            }
            // time complexity : 0(K*(n-k-1)) -> O(k*n)

            return ans;
        }

        // another lesss complex solution --> available --> plz watch video
    }
    public static void main(String[] args) {

    }
}

package Hashset;

import java.util.HashSet;

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements seqquence.
input 1 :
n = 6;
nums = [100,4,,200,1,3,2]
Output 1
 4
*/
public class H02_ConsecutiveLargest {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        for(int num : nums) st.add(num);
        int MaxStreak = 0;
        for(int num : st) {
            if(!st.contains(num-1)){   // num is the starting point of a sequence
                int currNum = num;
                int currStreak = 1;  // length of current consecutive sequence
                while(st.contains(currNum+1)){
                    currStreak++;
                    currNum++;
                }
                MaxStreak = Math.max(MaxStreak,currStreak);
            }
        }
        return MaxStreak;
    }
}

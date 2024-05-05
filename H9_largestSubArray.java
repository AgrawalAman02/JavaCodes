package HashMap;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of length N , find the length of the largest subarray with sum equals 0
 */
public class H9_largestSubArray {
    public static int LargsetSubArray(int[] arr, int n){
        Map<Integer,Integer> mp = new HashMap<>();
        int maxLen = 0 , prefSum = 0;
        mp.put(0,-1);
        for(int i = 0 ; i<n; i++){
            prefSum += arr[i];
            if(mp.containsKey(prefSum)){
                maxLen = Math.max(maxLen,i-mp.get(prefSum));
            } else{
                mp.put(prefSum,i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int [] arr = {1,3,4,6,78};
        int res  = LargsetSubArray(arr,arr.length);
        System.out.println(res);
    }
}

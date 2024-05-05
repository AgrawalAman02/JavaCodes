package HashMap;

import java.util.HashMap;
import java.util.Map;

public class H8_twoSumHashmapApproach {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = {-1};
        // So we need a hashMap where we store value and index of array
        // if we got the value whose sum with the already present key in map equals target
        // then we return that else we put that value and index

        Map<Integer,Integer> mp = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            int partner = target - nums[i];
            if(mp.containsKey(partner)){
                res = new int[]{i,mp.get(partner)};
                return res;
            } else {
                mp.put(nums[i],i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,7,-1};
        int target = 6;
        int [] res = twoSum(arr,target);
        if (res[0] == -1) {
            System.out.println("No pair found.");
        } else {
            System.out.println(res[0] + " " + res[1]);
        }
    }
}

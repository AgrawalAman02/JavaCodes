package HashMap;
/*
GIven an array of length n and a target , return a pair (indices) whose sum is equal to the target.
if there is no pair present, return -1;
(each input hae only one output and one index is not taken twice)
INPUT:
n = 4
arr[] = {1,5,7,-1}
target  = 6

OUTPUT:
0 1
 */
public class H7_TwoSum {
    public static int[] twoSum(int[] nums, int target){
        int[] res = {-1};
        for(int i = 0 ; i<nums.length;i++){
            for(int j = i +1; j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res = new int[]{i,j};
                    return res;
                }
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

        // or we can use the for loop upto res.length ;
        // here it has the time complexity of n2
        // so we can use another approach

    }
}

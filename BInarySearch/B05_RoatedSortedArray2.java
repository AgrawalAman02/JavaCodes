package BInarySearch;
/*
Given the rotated sorted array of integers, which contains distinct elements and an integer target,
return the index of the target if it is in the array . Otherwise return -1;
 */
public class B05_RoatedSortedArray2 {
    public static void main(String[] args) {
        int[] arr = {3,4 ,5,1,2};
        int target = 1;
        int st = 0;
        int n = arr.length;
        int end = n-1;
        int ans = -1;
        while (st<= end){
            int mid = st + (end- st )/2;
            if(arr[mid] == target){
                ans = mid;
                break;    // this break is necessary
            }
            else if(arr[mid]<arr[end]){   // mid to end is sorted
                if(target >arr[mid] && target <= arr[end]) st = mid+1;   // if target lies between this sorted part so now we search in this part
                else end = mid-1; // else go to the other part
            } else {    // st to mid is sorted as mid to end is not sorted so other must be sorted
                if(target >= arr[st] && target < arr[mid]) end = mid -1;
                else st = mid +1;
            }
        }
        System.out.println(ans);
    }
}

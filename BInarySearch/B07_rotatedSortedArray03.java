package BInarySearch;
/*
Search element in the rotated sorted array with duplicates elements.Return true if thr element is found,
else returns false.

i/p - [ 0,0,0,1,1,2,0,0,0], target = 2
o/p - true
 */

/*
here priblem arises if we do the code of the b05 :
  the problem  is that if:
        st == mid == end == 1 (same element) (then how we can solve this )
        let we got 1 in all three places
        if 1 is not our target , all these 1s are our no use to us
        so st++
        end --

        if after that still mid == end so then pivot is never between the mid and end

 */
public class B07_rotatedSortedArray03 {
    public static void main(String[] args) {
        int[] arr = {0,0,0,1,1,2,0,0,0};
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
            // for duplication
            else if(arr[st] == arr[mid] && arr[end] == arr[mid]){
                st++;
                end--;
            }
            else if(arr[mid]<=arr[end]){   // mid to end is sorted   // done some updation
                if(target >arr[mid] && target <= arr[end]) st = mid+1;   // if target lies between this sorted part so now we search in this part
                else end = mid-1; // else go to the other part
            } else {    // st to mid is sorted as mid to end is not sorted so other must be sorted
                if(target >= arr[st] && target < arr[mid]) end = mid -1;
                else st = mid +1;
            }
        }
        System.out.println(ans + " only gives index to check whether present or not");
    }
}

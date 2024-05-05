package BInarySearch;
/*
A rotated sorted array is a sorted array on which rotation is been performed some no. of times .
Given a rotated sorted array, find the index of the minimum element in the array.
Follow 0-baed indexing.

it is guranteed that all the elements in the array are unique.

I/p - [3,4,5,1,2]
o/p - 3
 */
public class B04_Rotated_sorted_Array {
    public static void main(String[] args) {
        int [] arr = {3,4,5,1,2};
        int n = arr.length;
        int st = 0 , end = n-1 ;

        int idx = -1;
        while (st<= end){
            int mid = st+ (end - st)/2;
            if(arr[mid]>arr[n-1]){
                st = mid+1;
            } else{
                idx = mid;
                end = mid -1;

            }
        }
        System.out.println(idx);
    }
}

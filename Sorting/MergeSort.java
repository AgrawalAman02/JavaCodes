//divide and conquer using recursion
package Sorting;


public class   MergeSort {
    static void displayArr(int[] arr){
        for(int val : arr){
            System.out.print(val + " ");
        }
    }

    //how to merge two sorted arrays?
    static void merge(int[] arr, int l, int mid, int r){
//        first we have to find the size of the two array we have to made
//         because here we need to made a left and right array
        int n1 = mid - l +1;
        int n2 = r - mid;//(r-mid-1+1)
        int[] left = new int[n1];
        int[] right = new int[n2];
        int i, j, k;
//        now we have to insert he element in left and right arr as both the arr are initially empty n
//        i.e. we have to fetch that index element from the array(divided) that is being passed here
        for(i=0; i<n1;i++){
            left[i]= arr[l+i];    // since l!= 0 always . sometimes we have to sort the arr from any position. so we are adding the l to i;
        }
        for(j=0; j<n2;j++){
            right[j]= arr[mid +1 +j]; // since l!= 0
        }
        i=0;  // why declare here? because we r using this i again after the loop
        j=0;
        k=l;  // to update the initial array from lth  position
        while(i<n1 && j<n2){
            if(left[i]<right[j]){
                arr[k++] = left[i++]; // we will update the initial array from lth  position
            }
            else{
                arr[k++]  = right[j++];
            }
        }

        while(i<n1){  //still
            arr[k++]= left[i++];
        }
        while(j<n2){     // or still
            arr[k++] = right[j++];
        }
    }

    static void mergeSort(int[] arr, int l, int r){
        if(l >= r) return;  // for finding mid if l and r poitns the dame no. then we can say we r at the mid

        int mid = l + (r-l)/2;   // we can use a+b)/2 also  but if arr is very large than a + b become out of bound of int
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    public static void main(String[] args) {
        int[] arr = {4,1,3,5,2};
        int n = arr.length;
        System.out.println("Array before sorting : ");
        displayArr(arr);   // 4 1 3 5 2
        mergeSort(arr,0,n-1);

        System.out.println("\nArray after  sorting ....");
        displayArr(arr);   // 1 2 3 4 5
    }
}

/*
time complexity -> O[n(log(n))]  -- means very good time complexity
space complexity -> O(n)
 this algorithm takes extra space(so it is not a inbuilt function),  so we don't use this algo when there is no extra space in system


 it is a depth-first type of algorithm
 */

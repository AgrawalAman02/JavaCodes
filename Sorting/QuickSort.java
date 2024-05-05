package Sorting;

public class   QuickSort {
    static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x]= arr[y];
        arr[y] = temp;
    }
    static void displayArr(int[] arr){
        for(int val : arr){
            System.out.print(val + " ");
        }
    }

    static int partition(int[] arr, int st, int end){
        int pivot = arr[st];
        int count = 0;
        for(int i=st+1; i<= end;i++){
            if(arr[i]<=pivot) count++;   // equal because to have all the duplicate elemnet on the left side
        }
        int pivotIdx = st+ count;  // st + count bcoz st may be anything not necessary arrr[0]
        swap(arr,st,pivotIdx);
        int i = st,j= end;

//         elements lesser or equal -> left side and greater -> right side of pivot/ pivotIdx
        while(i<pivotIdx && j> pivotIdx){
            while(arr[i]<= pivot) i++;
            while(arr[j]> pivot) j--;
//       now if arr[i] not less than pivot then loop breaks slly for j in not more then we swap
            if(i< pivotIdx && j> pivotIdx){
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        return pivotIdx;
    }
    static void quickSort(int[] arr, int st,int end){
        if(st>= end){
            return;
        }
        int pt = partition(arr,st,end);
        quickSort(arr,st,pt-1);
        quickSort(arr,pt+1,end);
    }
    public static void main(String[] args) {
        int[] arr = {4,6,3,6,4,1,5,4};
        int n = arr.length;
        System.out.println("Array before sorting : ");
        displayArr(arr);   // 4 1 3 5 2
        System.out.println();
        quickSort(arr,0,n-1);

        System.out.println("\nArray after  sorting ....");
        displayArr(arr);
    }
}
/*
--> it is not a stable algorithm as order of duplicate elements changed
--> time complexity
    --> avg case/ best case -> O(nlog(n))
    --> worst case          -> O(n2)
                                    --> can mostly be avoided if we use RANDOMIZED QUICK SORT...
 --> space complexity
    --> avg /best case : log n (if we consider implicit stack  else O(1)) . since log n is very small we consider it as inplace algorithm
    --> worst case : O(n)    (but it usually not appears)  ( appears only when array is sorted and we take pivot as start)

 */
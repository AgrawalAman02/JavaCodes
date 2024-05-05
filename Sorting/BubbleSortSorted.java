//How to optimise the bubble sort in the nearly sortd arrays?
package Sorting;

public class BubbleSortSorted {
    public static void main(String[] args) {
        int i,j;
        int[] arr = {2,1,3,4,5};
        for(i=0;i<arr.length-1;i++){  // as loop is going n-1 turn
            boolean flag = false;   // declared to check where the sawpping done or not for each iteration of i
            for(j=0;j<arr.length-i-1;j++){
//                 last i elements are already in correct sorted positions,
//                 so no need to check again
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = temp;
//                    so here if j>j+1 them swapping done so i make the flag true means swapping dne
                    flag= true;
                }
            }
            if(flag== false){/* if(!flag){}  is also true for false  */  // swaps not done!
                break;
            }

        }
        for(i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
/*
so this optimaisation improves the best case not worst case
here in this case best case is O(1)
because only 1 time loop goes after that the arr is sorted ...
 */
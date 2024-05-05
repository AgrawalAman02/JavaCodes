// print all the value in an array recursively
package Recursion;

public class PrintElementsArray {
    public static void main(String[] args) {
        int[] arr= {1,2,17,4,5};
//        printArr(arr,0);
        // for finding max
        System.out.println(maxArray(arr,0));
        // for finding sum of elements
        System.out.println(sumArray(arr,0));
    }
    static void printArr(int[] arr, int idx){

        if(idx==arr.length) return;
        System.out.print(arr[idx]);
         printArr(arr,idx+1);

    }
    // for finding the max of an array
    static int maxArray(int[] arr, int i){
        if(i== arr.length-1){
            return arr[i];
        }
        // small problem -> i+1 , end of the array -> max-> return
        int max = maxArray(arr, i+1);
        // self work and final ans
        return Math.max(arr[i], max);

    }
    static int sumArray(int[] arr, int idx){
        if(idx==arr.length-1) return arr[idx];
        else return arr[idx]+ sumArray(arr,idx+1);
    }
}

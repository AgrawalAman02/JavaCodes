/*
Given an integer array arr , move all 0's to the end of it while maintaining
the relative order of the non-zero elements.
Note that ypu must do this in-place without making a copy of the array.
Input: 050242
Output: 534200
 */
package Sorting;

public class question1OnSorting {
    public static void main(String[] args) {
        int [] arr= {0, 1,10,5,0,2};
        for(int i = 0;i<arr.length-1;i++){
            for(int j= 0;j<arr.length-i-1;j++){
                if(arr[j]==0 && arr[j+1]!=0){
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }
        for (int j : arr) {    // enhanced for each loop
            System.out.print(" " + j);
        }
    }
}

package GreedyAlgorithm;

import java.util.Arrays;

/*
        *** MINIMUM ABSOLUTE DIFFERENCE PAIRS ***
   Given two arrays A and B of equal length n . Pair each element of array A to an element
   in array B ,such that "sum of absolute differences of all the pairs is minimum"

   * A = [4,1,8,7]
   * B= [2,3,6,5]

   * we can sort both the input because the absolute difference will be less if the datas are closer to each other
   * so if sorted then the min is present in the start of the both the array so the difference is min .
   * and the difference between the max is also the smallest
   * so we need the two closest no. in the A and B .
   *
   * similarly if we want the max absolute difference so we should sort on ein ascending and other in descending
 */
public class G03_MinAbsoluteDifferencePairs {
    public static void main(String[] args) {
        int [] A = {4,1,8,7};
        int [] B = {2,3,6,5};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        for (int i = 0;i<A.length;i++){
            minDiff += Math.abs(A[i]-B[i]);
        }

        System.out.println("Minimum absolute difference of pairs = " + minDiff);

//          T.C. = O(n.log(n))
    }
}

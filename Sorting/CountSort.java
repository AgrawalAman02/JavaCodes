/*
--> it is a non comparison based algorithm not like other sort
--> here range of no. defined i.e. it is defined the what are the  highest value and lowest value in the array
--> it is not a in place algorithm
--> only under certain condition its time complexity is better than O(log n)
 */

package Sorting;

public class CountSort {
    public static void main(String[] args) {
        int [] arr= {2,1,4,4,6,2,1,9,8,2,4,8};
//          we will first find the max no. present in the arr because the count arr have the size from 0 to that no.
//          beacuse it will store the frequency of each no. how many times its repeats....
        int max = Integer.MIN_VALUE;
        for(int i =0; i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println(max);

        int[] frq = new int[max+1];   // we add plus 1 bcoz we r looking the arr from 0 to that no. but max will have 1 to that no. or 0 to n-1
        for(int i=0;i<arr.length;i++){  // make frequency arr -> T.C. -> n

            frq[arr[i]]++;           // this will traverse through the length of the arr and find arr[i] then in frq arr it inc the value of that index whose value equals arr[i]
        }
        System.out.print("the frequency array is : ");
        for(int i=0;i<frq.length;i++){
            System.out.print(frq[i]+ " ");
        }

//         u can comment below...

        System.out.println();
//        int k=0;
//        for(int i=0;i<frq.length;i++){
//            for(int j=0;j<frq[i];j++){
//                arr[k++]=i;             // here the loop will run the same no. of times the value present in  frq[i]
//                                        // if frq[1] have 0 loop go 0 times so if 3 then each time the same i will fill in k++ location upto j times in arr
//            }
//        }
//
//        System.out.print("the array after count sort is (unstable): ");
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+ " ");
//        }

/*
it is purely unstable algo. so we need to fix this algo so that first element from the main arr comes in first position
so we make  a prefix sum arr tht have element which will have element having sum of all the previous element
so the elelemt in 3rd index repreent sum of all element upto 3rd index
now ig 3rd index have 5 means the last pos of 3 is 5th pos means 4th index slly if 4th index have again 5 means 4 also have last index 5 but 5 occupied with 3 so 4 is not present


// we will convert count arr into prefix sum arr
now we look in the original arr from back side
so last element is having 8 so we will see the index 8 in prefix sum arr which have let 11 means it have 11 is the last pos of 8
means there are many element before 8th pos maybe more  8 will be before but last 8 will be at 11 pos
now we dec the value at 8th index of prefix arr
so when we again see 8 in the orignal arr(from the last or next 8 ) we will place it in 10th pos (surely it will be in pre consecutive pos so we decrease the value in 8th index)
niw we see 4 so fing at index 4 what will be its las t pos then dec its value
 */

        int n = arr.length;
        int [] output = new int[n];
//        make prefix sum arr of the count / frq array
        for(int i = 1; i<frq.length;i++){  // T.C. -> max
            frq[i]+= frq[i-1];
        }

//        find the index of each element in original array and put it in the output
        for(int i=n-1;i>=0;i--){  // T.C -> n
            int idx = frq[arr[i]]-1;
            output[idx]= arr[i];
            frq[arr[i]]--;
        }

//        now copy the elements of output arr to original array
        for(int i=0; i<n;i++){  // t.c. -> n
            arr[i] = output[i];
        }

        System.out.print("the array after count sort is (stable): ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
/*
so time compexity = max + nc+ nc+ nc= 3c.n + max = ignoring constant -> max +n= n+k (worst case).
                                                                     -> n+k(avg case)
                                                                     -> n (best case when k is very less)

   space complexity -> n+k
 */


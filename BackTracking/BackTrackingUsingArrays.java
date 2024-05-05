package BackTracking;

public class BackTrackingUsingArrays {
    public static void changeArr(int [] arr,int i, int val){
        if(i== arr.length){
            printArr(arr);
            return;
        }

        // recursion
        arr[i]= val;   // first we assign the val to arr
        changeArr(arr , i+1,val+1); // fnx call step
        // now we again calling the f(x) to form a stack and go to the next level by increasing i+1 and then store val +1 in the next iterrator
//      now the stack calls itself again and again until i = arr.length then it prints
//        now base case arrives then it started to return the value and in that time we are changig the value of  b y dec it by 2 before returning
         arr[i] = arr[i]-2;   // backtracking step
    }
    public static void printArr(int [] arr){
        for (int i = 0 ; i< arr.length;i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = new int[5];
        changeArr(arr,0,1);  // satrting index is 1 and starting val is 1 to change in arr
        printArr(arr);

    }
}
// time complexity = 2n so O(n)
// space = O(n) as stack of n levels

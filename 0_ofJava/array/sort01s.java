//sort an array consisting only 0 and 1

package array;

public class sort01s {
    /*
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0};
        int count = 0;
        System.out.print("the array before sorting is : ");
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        for (int i = 0; i < arr.length ; i++) {

            if (arr[i] == 0) {
                count++;
            }
        }
        for (int i = 0; i < arr.length ; i++) {
            if (i < count ) {
                arr[i] = 0;
            } else arr[i] = 1;
        }
        System.out.print("the array after sorting is : ");
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]);
        }


    }

     */
    // as this program takes 2 loop for sorting

    // optimised method;;;
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0};
//        for(int i=0,j= arr.length-1;i<j;i++,j--){
//            if(arr[i]==1&&arr[j]==0){
//                int temp = arr[i];
//                arr[i]=arr[j];
//                arr[j]=temp;
//            }
//
//        }

        // do it by while loop it  good
        int n= arr.length;
        int left = 0, right = n-1;
        while(left<right){
            if(arr[left]==0){
                left++;
            }
            if(arr[right]==1){
                right--;
            }
            if(arr[left]==1&&arr[right]==0){
                int temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }

        }
        System.out.print("the array after sorting is : ");
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]);
        }
    }

}

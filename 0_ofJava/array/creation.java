package array;

import java.util.Scanner;

public class creation {
    public static void main(String[] args) {
        int [] qrr;
        int arr[]= new int[50];
        int arr2[]= {1,2,3};
        String str[] = {"Aman", "kumar"};
        float arr3[]= {32.3f,55.6f,45,65,76.2f};
        System.out.println(arr2[2]);
        System.out.println("enter the elements of array : ");
        Scanner sc = new Scanner(System.in);
        for (int i=0;i<=2;i++) {
            System.out.println("enter "+i+" element :- ");
            arr[i]=sc.nextInt();
            System.out.println("the arr["+i+"] is "+arr[i]);


        }
        for (int i=0;i<=3;i++){
            System.out.print(arr[i]+"\t");
        }
        ////////*********************/////////
        System.out.println("the length of floating array is :- "+arr3.length);
    }
}

package ARRAY_LIST;

import java.util.*;

public class SwapArrayList {

    public static void swapList(ArrayList<Integer> list,int idx1,int idx2){
        int temp = list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("the list before swap : "+list);
        int idx1,idx2;
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the first index to swap:");
        idx1 = sc.nextInt();
        System.out.println("Enter the 2nd index to swap with first : ");
        idx2 = sc.nextInt();
        swapList(list,idx1,idx2);
        System.out.println("the list after swap : "+list);


    }
}

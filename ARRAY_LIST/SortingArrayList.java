package ARRAY_LIST;

import java.util.ArrayList;
import java.util.Collections;

public class SortingArrayList {
/*
we had learn many method in array to sort but here we will use built-in method to sort
one for sorting array is Arrays.sort(arr_name); where Arrays is a class whaich have this sort method
for ArrayList
we use Collections.sort(list_name) where Collections is also a class

P.S. USE Collections NOT Collection AS LATTER ONE IS A INTERFACE NOT A CLASS
this will sort the list in ascending order
for using Collections we have to import java.util.Collections;
 */
public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(23);
    list.add(2);
    list.add(1);
    list.add(45);
    list.add(15);
    System.out.println("the initial list is: "+ list);
    Collections.sort(list);
    System.out.println("the final list is : "+ list);

    // if we want to sort in descending order then how we can do it  so look below
    Collections.sort(list,Collections.reverseOrder());
//     so Collections.reverseOrder() is a comparator which a set a fnx  to define logic how to sort;
//    it can be defined for a object too
    System.out.println("the list in descending order is : "+ list);
}
}

package ARRAY_LIST;

import java.util.ArrayList;

public class MultiDimArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
//                          this integer is  not necessary to write
//        if we r writing then means only integer is allowed

//        now in big main list we have to make a small list
        ArrayList<Integer> list1 = new ArrayList<>();
//        now we add elements in this list 1
        list1.add(21); list1.add(34);
        list1.add(23);
//        now add this list1 to main list
        mainList.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(31);
        list2.add(210);
        mainList.add(list2);

        // print
        for(int i = 0;i<mainList.size();i++){
//            now we will get the ith element of main list which is also a list so we will store it in a list name currList and then fetch that lust in next loop
            ArrayList<Integer> currList = mainList.get(i);
            for(int j = 0;j<currList.size();j++){
                System.out.print(currList.get(j) +" ");
            }
            System.out.println();
        }

        System.out.println(mainList);



    }
}

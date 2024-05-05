package ARRAY_LIST;
import java.util.ArrayList;
public class Intro {
    /*
    --> dynamic size
    --> primitive data types cant be stored directly
     */
    public static void main(String[] args) {
        // Java Collection Framework
        // since array have fix size but array list dont hve so we dont need
//        we will have | Integer | Boolean | String| Float | class which we will use
        // ClassName objectName = new ClassName();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String>  l2 = new ArrayList<>();
        ArrayList<Boolean> l3 = new ArrayList<>();
//          Add element - O(1)
        //  Get Element - 0(1)
        //  Remove Element- 0(n)
        //  set Element at Index O(n)
        //  conatains Element - O(n)

        // to add element
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        // to print the list
        System.out.println(list);
        list.add(8);
        list.add(1,45);   // O(n)
        System.out.println(list);

        // to get
        System.out.println(list.get(2));
        int element = list.get(4);
        System.out.println(element);

        // remove eelement
        list.remove(2);
        System.out.println(list);
        // set
        list.set(3,87);
        System.out.println(list);

        // contain if?
        System.out.println(list.contains(1));
        System.out.println(list.contains(99));

        // size  - it is a method not property
        System.out.println( list.size());

        // we can also print the lsit by loop
        for (int i = 0 ; i< list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        // reverse
        for(int i = list.size()-1;i>=0;i--){     // O(n)
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        //find max
        int max = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){     //O(n)
//            if(max<list.get(i)){
//                max = list.get(i);
//            }

            //        we can do like above
//                  but we can also do by one line

            max = Math.max(max,list.get(i));   // it comapres between max and list.get(i) and return the max to max

        }


        System.out.println(max);


    }
}

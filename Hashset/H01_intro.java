package Hashset;

import java.util.HashSet;

/*
                                 Set interface

        HashSet:                LinkedHashset:                  Sorted List
        - unordered             - order of insertion            - Tree Set
        - unique                - LinkedList + Hashtable            - Sorted Order
        - Hashing internally                                        - Self balancing BST
                                                                    - Red Black TREE
 */
public class H01_intro {
    public static void main(String[] args) {
        HashSet<String> st = new HashSet<>();
        st.add("Aman");
        st.add("Abhi");
        st.add("Anu");
        st.add("Aman");
        System.out.println(st);
        System.out.println(st.contains("Aman"));
        System.out.println(st.size());
        st.remove("Abhi");
        System.out.println(st.contains("Abhi"));
        System.out.println(st.size());
        for(String s : st){
            System.out.print(s + " ");
        }
    }
}

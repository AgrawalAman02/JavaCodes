package Hashset;

import java.util.HashSet;

/*
you are given n distinct pairs. eachpair is numered from 1 to n . all these pair are initially put in a bag.
You need to pair up each number . Yu take numbers one by one from the bag and for each no. u look
whether the pair of this numer has already been out of the bag , or not . if not (that means the pair of
this no. is still in the bag ), you put hte current number on the table in front of him. Otherwise, you put
both numbers from the pair aside. Print the maximum number thst were on the table at the same time.
        INPUT:
        1
        1 1

        Output:
        1
 */
public class H03_question {
    static int maxNumbersOnTable(int[] bag){
        HashSet<Integer> table = new HashSet<>();
        int max = 0;
        for(int i = 0 ; i <bag.length;i++){
            int p = bag[i];
            if(!table.contains(p)){
                table.add(p);
                max = Math.max(table.size(),max);
            } else{
                table.remove(p);
//                max = Math.max(table.size(),max);     // no need here
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,3,2,3};
        System.out.println(maxNumbersOnTable(nums));
    }
}

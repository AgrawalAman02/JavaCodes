package GreedyAlgorithm;
import java.util.*;
/*
ypu are given n activities with their start and their end times. Select the maximum number of the activities
that can be performed by a single person , assuming that a person can only work on a sing;e
activity at a time . Activies are sorted according tp end time .

start = 10, 12 , 20]
end = [ 20, 25, 30]

ans = 2(A0 & A2)

same logic in DISjoint set or max. meeting in a row problem
 */

/*
hame sbse jldi khatam hone wala activity krna hai , so
1> sort on the basis of end time
2> A0 (first activity)
    |
    ---> end time
3> non overlapping (disjoint) activity
        |
        ---> start time of next activity > =  last chosen activity previous activity
    4> count ++;
 */
public class G01_ActivitySelection {
    public static void main(String[] args) {
        int [] start = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        // end time based sorted already
        // but if we want to sort then hpw we do?
        // we make a 2d array of 3 columns : 1st colm cont index , 2nd contain start val, 3rd contain end val
        int activities[][] = new int[start.length][3];
        for(int i = 0  ; i<start.length;i++){
            activities[i][0] = i;
            activities[i][1]= start[i];
            activities[i][2] = end [i];
        }

        // use lambda function for sorting on the basis on col. 2 i.e. end time
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // now change the code as per sorting
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity
        // add the first activity
        maxAct = 1;  // so it inc. by 1
//        ans.add(0);     // now 0th index activity is added
        ans.add(activities[0][0]);
        int lastActEnd = activities[0][2];
        for(int i = 1; i<end.length;i++){
            if(activities[i][1] >= lastActEnd) {
                // select the activity
                maxAct++;
                ans.add(activities[i][0]);
                lastActEnd = activities[i][2];
            }
        }

        System.out.println("Max activities = "+ maxAct);
        for(int i = 0 ; i<ans.size();i++){
            System.out.print("A" +ans.get(i)+ " ");
        }
        System.out.println();

    }
}

package GreedyAlgorithm;


import java.util.Arrays;
import java.util.Collections;

/*
                            ----->>> CHOCOLA PROBLEM <<<-------
        we are given a bar of chocolate composed of a m*n square pieces. One should break the chocolate into single squares.
        Each break of a part of a chocolate is charged a cost expressed by a positive integer. This cost does not depend on
        the size of the part that is being broken but only depends on the line that breaks goes along. Let us denote the
        costs of breaking along consecutive vertical lines with x1, x2,........, xm-1 and along horizontal lines with
        y1,y2,y3,........,yn-1.
        Compute the minimal cost of breaking the whole chocolate into single squares.

                    --- --- ---
                   |   |   |   |
                    --- --- ---
                   |   |   |   |
                    --- --- ---
                   |   |   |   |
                    --- --- ---

      ===>>> use all cuts = order of cuts
            after each cut -> chocolate pieces increases
              so expensive cut first
              and cheap cut later
            cost of vertical cut -> hp *x
            cost of horizontal cut -> vp*y

 */
public class G07_ChocolaProblem {
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = {2,1,3,1,4};  // m-1
        Integer costHor[] = {4,1,2};  // n-1

        // now sort both the array in descendng order
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor,Collections.reverseOrder());

        int h = 0, v = 0;  // ptr for both the arrays for comparing
        int hp = 1, vp = 1;  // no. of pieces of both dimension;
        int cost = 0;

        while(h<costHor.length && v<costVer.length){   // until and unless we traverse whole array
            // vertical cost < hor cost
            if(costVer[v] <= costHor[h]) {  // horizontal cut
                cost += (costHor[h] * vp);   // as cut is through the vertical pieces
                hp++;
                h++;
            } else{  // vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }

        }
        // if stilL any ptr not reached the end pts
        while(h<costHor.length){
            cost += (costHor[h] * vp);   // as cut is through the vertical pieces
            hp++;
            h++;
        }
        while (v<costVer.length){
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println("The min cost of the cut is " + cost);
    }
}

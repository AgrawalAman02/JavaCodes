package Stack;

import java.util.Stack;

/*

..................................................G-F-G...........................................................
A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people,
find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that
if an element of row i and column j  is set to 1 it means ith person knows jth person.
Here M[i][i] will always be 0.
Note: Follow 0 based indexing.
Follow Up: Can you optimize it to O(N)

--> if we solve it by array then its complexity is O(n2), so we use stack
 */
public class A21_CelebrityProb {
    static int celebrity(int[][] M, int n) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(i);
        }
        while (st.size() > 1) {
            int v1 = st.pop();
            int v2 = st.pop();
            if (M[v1][v2] == 0) { // sayad v1 celeb ho i.e. v1 dont know v2 or v2  know v1
                st.push(v1);
            } else if (M[v2][v1] == 0) st.push(v2);    // v2 dont know v1 or v1  know v2
        }
        if (st.size() == 0) return -1;   // no one is celeb
        int potential = st.pop();    // else may be
        for (int j = 0; j < n; j++) {    // checking for its row and col.
            if (M[potential][j] == 1) return -1;   // if in that row anyone is 1 means anyone knows him then return -1
        }
        for (int i = 0; i < n; i++) {   // if in that col. anyone is 0 means that potential dont knows anyone then return -1
            if (i == potential) continue;    // but middle is always 0 so skip
            if (M[i][potential] == 0) return -1;
        }
        return potential;  // else he is celeb.....
    }

    public static void main(String[] args) {
        int[][] M = {{0,1,0},{0,0,0},{0,1,0}};
        System.out.println(celebrity(M,3) +" is celebrity");
    }
}

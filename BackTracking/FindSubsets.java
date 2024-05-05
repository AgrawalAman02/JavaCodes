package BackTracking;

public class FindSubsets {
    public static void findSubsets(String str, String ans, int i){
        //base case
        if(i== str.length()){
            if(ans.length()==0) System.out.print("NULL");
            System.out.print(ans + "\t");
            return;
        }
        // recursion
        // yes
        findSubsets(str,ans + str.charAt(i), i+1);  // if yes then same string will pass and then we add the character at i + 1  and then inc the i;
//         if no then we increasee the  iteraror but dint add anything
        findSubsets(str,ans,i+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        findSubsets(str, "", 0);
        // we pass str, and in ans string i pass empty strng and iterator is 0 ;

    }
}
// t.c = O(n*2^n) --> as no . of subsets are 2^n and for 1 subsets  it require n calls so ovrall n*2^n
package ARRAY_LIST;

import java.util.ArrayList;

public class PairSum1 {
    public static boolean pairSum(ArrayList<Integer> list, int target){
        for (int i =0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)+list.get(j)==target){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // 1 2 3 4 5 6
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(pairSum(list,5));
        // using two poointer approach
        System.out.println(pairSum2ptr(list,5));
    }

    public static boolean pairSum2ptr(ArrayList<Integer> list, int target) {
        int i =0,j=list.size()-1;
        while(i<j){
            if(list.get(i)+list.get(j)==target){
                return true;
            }
            else if(list.get(i)+list.get(j)<target){
                i++;
            }
            else{
                j--;
            }
        }
        return false;
    }
}

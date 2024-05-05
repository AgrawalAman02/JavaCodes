package HashMap;

import java.util.*;

// given an array , find the most frequent element in it. if there are multiple elements that appear a
// maximum number of times , print any of them.
public class H2_frequencyArray {
    static void frequency(int[] arr, int n){
        Map<Integer,Integer> mp = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int maxKey = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(mp.containsKey(arr[i])== false){
                mp.put(arr[i],1);
            }
            else{
                mp.put(arr[i],mp.get(arr[i])+1);
            }
        }
        for(Map.Entry<Integer,Integer> e : mp.entrySet() ){
            System.out.printf("%d -> %d\n",e.getKey(), e.getValue() );   // for getting from map we used mp.keySet(),mp.values() but here we r getting from entry so we used these
        }
        System.out.println();
        for(var e : mp.entrySet()){
            if(e.getValue()>max){
                maxKey = e.getKey();
                max  = e.getValue();
            }
        }
        System.out.println("the frequency is maximum for key :-> "+ maxKey + " with frequency " + max);
        // ------------or--------------
        for(var e : mp.keySet()){
            if(mp.get(e)>max){
                maxKey = e;
                max  = mp.get(e);
            }
        }
        System.out.println("the frequency is maximum for key :-> "+ maxKey + " with frequency " + max);
    }
    public static void main(String[] args) {

        int[] arr = {1,3,2,5,2,2,3,4,4,4,4,2,1,3,4,1,4,1};
        int n = arr.length;
        frequency(arr,n);
    }
}

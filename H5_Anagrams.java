package HashMap;

import java.util.*;
/*
Check whether tw Strings are anagram of each other . return true if they are else return false .
An anagram of a string is another string that cinatain same characyers , inly the order of characters can be different . eg: abcd and dabc are anagrams

so we would see :
i> length of both should be equal
ii> freq of each char must be same
iii> no character should be extra or different
 */
public class H5_Anagrams {
    static boolean checkFrequency(String str1,String str2,int n){
        Map<Character,Integer> freq = new HashMap<>();
        for(int i = 0; i<n;i++){
            char ch = str1.charAt(i);
            if(freq.containsKey(ch)== false){
                freq.put(ch,1);
            } else{
                freq.put(ch,freq.get(ch)+1);
            }
        }

        // or we can make a function of HashMap<Character,Integer> type to check the frequency without using the map twice

        Map<Character,Integer> freq2 = new HashMap<>();
        for(int i = 0; i<n;i++){
            char ch2 = str2.charAt(i);
            if(freq2.containsKey(ch2)== false){
                freq2.put(ch2,1);
            } else{
                freq2.put(ch2,freq2.get(ch2)+1);
            }
        }
//        if(freq.equals(freq2)){
//            return true;
//        }
//        else return false;
        //   ooooooorrrrrrr
        return freq.equals(freq2);
        /*
        since we are making two freq map so we are using extra space . so we can optimise it by only using one map
        we amke freq map of 1st map check first check that whether that map contain every character of str2 or not , if not then return flase immediately
        else then , we decrease the value of freq of each character present in map .
        All value in map / freq should be 0 for str1 and str2 should be anagrams


        for(int i = 0 ; i < str2.length() ; i++){
            char ch = str2.charAt(i);
            if(!freq.containsKey(ch)) return false;  // freq is the map of str1
            freq.put(ch,freq.get(ch)-1);
        }

        for(Integers i : freq.values()){
            if(i!= 0 ) return false;
        }
        return true;
         */
    }

    public static void main(String[] args) {
        String input1 = "listen";
        String input2 = "siljnt";
        if(input1.length()==input2.length()){
            System.out.println(checkFrequency(input1,input2, input1.length()));
        } else {
            System.out.println("they are not anagram");
        }
    }
}

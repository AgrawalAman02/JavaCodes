package HashMap;

import java.util.HashMap;
import java.util.Map;

public class H6_IsomorphicStrings {
    public static boolean check(String str1, String str2, int n){
        Map<Character,Character> mp = new HashMap<>();
        for(int i = 0; i<n;i++){
            char ch = str1.charAt(i);
            char bh = str2.charAt(i);
            if(!mp.containsKey(ch)){
                mp.put(ch,bh);
            } else{
                if(mp.get(ch)!=bh){
                    return false;
                } else if (mp.containsValue(bh)) {    // as contains value is a linear op. so overall it makes this as quuadratic
                                                        // So we use hashset in place of hashmap bcoz it contaon only unique elsemnets
                    return false;
                } else return true;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        String input1 = "abcabdec";
        String input2 = "pqrpqspr";
        if(input1.length()==input2.length()){
            System.out.println(check(input1,input2, input1.length()));
        } else {
            System.out.println("they are not Isomorphic");
        }
    }
}

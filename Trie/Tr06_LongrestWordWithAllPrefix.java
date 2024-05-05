package Trie;
/*
Find the longest string in words such that every prefix of it is also in words

 words = ["a",banana,app,ap,apply,apple]
 ans = "apple"

- if all the prefix of a word in trie is present eow is true for all teh child in the trie
 */

public class Tr06_LongrestWordWithAllPrefix {
    static class Node{
        Node [] children = new Node[26];
        boolean eow = false;

        public Node(){
            for (int i = 0 ; i<26; i++){
                children[i] = null;
            }
        }
    }
    public static void insert(String word){  // O(l)
        Node curr = root;
        for(int level = 0 ; level <word.length();level ++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx]== null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key){// O(l)
        Node curr = root;
        for(int level = 0 ; level <key.length();level ++){
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx]== null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }
    public static Node root = new Node();
    public static String ans = "";

    public static void longestWord(Node root,StringBuilder temp){
        if(root== null) return;

        for(int i = 0; i<26;i++){
            if(root.children[i]!= null && root.children[i].eow== true){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length()> ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i],temp);
                temp.deleteCharAt(temp.length()-1); // backtracking
            }
        }
    }

    public static void main(String[] args) {
        String [] word = {"a","banana","app","ap","appl","apply","apple"};

        for(int i = 0 ; i<word.length;i++){
            insert(word[i]);
        }
        longestWord(root,new StringBuilder(""));
        System.out.println(ans);
    }
}

package Trie;
/*
Given a string of length n of lowercase alphabet characters, and we need to count the total no. of distinct substring of this string

str = "ababa"
ans = 10
 */
public class Tr05_CountUniqueSubstring {
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

    public static int countNodes(Node root){
        if(root== null){
            return 0;
        }
        int count = 0;
        for(int i =0; i<26;i++){
            if(root.children[i]!= null )
                count+= countNodes(root.children[i]);
        }
        return count+1;
    }
    public static void main(String[] args) {
        String str = "ababa"; // ans = 10

        // suffix -> insert in trie

        for(int i = 0; i<str.length();i++){
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println(countNodes(root));
    }
}

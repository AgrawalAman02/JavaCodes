package Trie;

public class Tr01_Inplementation {
    static class Node{
        Node [] children = new Node[26];
        boolean eow = false;

        public Node(){
            for (int i = 0 ; i<26; i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();

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

    public static void main(String[] args) {
        String[] words = {"the", "a","there","their", "any","thee"};
        for(int i =0 ; i<words.length;i++){
            insert(words[i]);
        }

        System.out.println(search("thee"));
        System.out.println(search("thor"));
        System.out.println(search("th"));
    }
}

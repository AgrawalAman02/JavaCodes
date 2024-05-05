package Trie;
/*
Find shortest unique prefix for every word in a given list.
Assume no word is prefix of another

arr[] - {zebra,dog,duck,dove}
ans = { z,dog,du,dov}
 */
public class Tr03_PrefixxProblem {
    static class Node{
        Node [] children = new Node[26];
        boolean eow = false;
        int freq;

        public Node(){
            for(int i= 0; i<children.length; i++){
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word){ // O(l)
        Node curr = root;
        for(int level = 0; level<word.length();level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }else curr.children[idx].freq++;
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static void findPrefix(Node root, String ans){
        if(root == null) return;
        if(root.freq == 1){
            System.out.println(ans);
            return;
        }

        for(int i = 0 ; i<root.children.length; i++){
            if(root.children[i] != null){
                findPrefix(root.children[i],ans+(char)(i+'a'));
            }
        }
    }
    public static void main(String[] args) {
        String [] arr = {"zebra","dog","duck","dove"};
        for(int i = 0; i<arr.length;i++){
            insert(arr[i]);
        }
        root.freq = -1; // since when root is created its freq become 1 by the constructer . so that in search op , the op dont end in root itself

        findPrefix(root,"");
    }
}

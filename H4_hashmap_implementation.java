package HashMap;

import java.util.LinkedList;



public class H4_hashmap_implementation {
    static class MyHashMap<K,V>{    // K,V - data types as per the main function what has been called
        public static final int DEFAULT_CAPACITY = 4;
        public static final float DEFAULT_LOAD_FACTOR = 0.75f;

        private class Node{
            K key;
            V value;
            Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n;  // the  no. of enteries in map
        private LinkedList<Node>[] buckets;

        private void initBucket(int N){   // N = capacity or size of bucket array
            buckets = new LinkedList[N];
            for(int i = 0; i<buckets.length;i++){
                buckets[i] = new LinkedList<>();     // in bucket array  a empty linked list to place in every index

            }

        }

        private int HashFunc(K key){
            int hc = key.hashCode();   // java has a pre defined hashcode function that convert key into hashcode , whichever the type of key;
            return (Math.abs(hc))% buckets.length;   // since hashcode generated can be negative and very bigger value , so we mod with bucket length to that that in range
        }

        private int searchInBucket( LinkedList<Node> ll,K key){    // traverses the ll  and looks for  a node with a key , if found it return its index , otherwise null;
            for (int i = 0 ; i< ll.size() ; i++){
                if(ll.get(i).key== key){
                    return i;
                }
            }
            return -1;
        }
        public MyHashMap(){  // constructor
            initBucket(DEFAULT_CAPACITY);
        }
        public int capacity(){
            return buckets.length;
        }
        public float load(){
            return (1.0f*n)/buckets.length;
        }
        public void rehash(){
            LinkedList<Node>[] oldBucket = buckets;
            initBucket(oldBucket.length*2);
            n=0;  // to maintain the size
            for(var bucket : oldBucket){
                for(var node : bucket){
                    put(node.key,node.value);
                }
            }
        }
        public int size(){  // return thr no. of enteries in map
            return n;
        }

        public void put(K key, V value){  // insert / update
            /*
            1. hashfunction :- bucketIndex(bi)
            2. buckets[bi] - traverse this LL and sees whether the key exists or not:
               - if yes: update the value in key
               - if no : add a new node
 */
            int bi = HashFunc(key);
            // so we dont direct put the function , first we search the key , and see whether the key present there or not
            LinkedList<Node> currbucket = buckets[bi];
            int ei = searchInBucket(currbucket,key);

            if(ei== -1) {  // means key doesn't exist ,and we have to insert a new node
                Node node = new Node(key, value);
                currbucket.add(node);
                n++;
            } else{
                Node currNode = currbucket.get(ei);
                currNode.value = value;
            }

            /*
            since now the default capacity is 4 , so after 4th element on adding the element the time comp. inc.
            so we need to rehash the hashmap. since this should be check during put function so we are using it here
            we do rehash when current capacity of bucket >= bucket.length* DEFAULT_LOAD_FACTOR
             */
            if(n>= buckets.length *DEFAULT_LOAD_FACTOR){
                rehash();
            }
        }

        public V get(K key){
            int bi = HashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket,key);
            if(ei != -1){
                Node currNode = currBucket.get(ei);
                return currNode.value;
            }
            return null;

        }

        public V remove(K key){
            int bi = HashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket,key);
            if(ei!= -1) {  // means key doesn't exist ,and we have to insert a new node
                Node currNode = currBucket.get(ei);
                V val = currNode.value;
                currBucket.remove(ei);
                n--;
                return val;
            } else{
                return null;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap<String,Integer> mp = new MyHashMap<>();
        System.out.println("testng ");
        mp.put("a",1);
        mp.put("b",2);
        System.out.println("CAPACITY IS : "+ mp.capacity());   // here capacity is 4 which is the capacirty before rehash
        System.out.println("load is :"+mp.load());
        mp.put("c",3);
        System.out.println("CAPACITY IS : "+ mp.capacity());   // now after 3 which is threshold value the map got rehashed and capacity is doubled
        System.out.println("load is :"+mp.load());
        mp.put("d",4);
        // testing size
        System.out.println("Size is "+ mp.size());
        // testing get and updation
        System.out.println(mp.get("c"));
        mp.put("c", 43);
        System.out.println("size is "+mp.size());
        // testing get
        System.out.println(mp.get("a"));
        System.out.println(mp.get("b"));

        System.out.println(mp.get("c"));

        System.out.println(mp.get("d"));

        System.out.println(mp.get("college"));
        System.out.println("removed "+ mp.remove("c"));
        System.out.println("check removed c :-"+ mp.remove("c"));
        System.out.println("size is "+mp.size());

        mp.put("x", 65);
        mp.put("y", 69);
        System.out.println("size is "+mp.size());
        System.out.println("x is "+mp.get("x")+" y is "+mp.get("y"));
        System.out.println("CAPACITY IS : "+ mp.capacity());
        System.out.println("load is :"+mp.load());
    }
}

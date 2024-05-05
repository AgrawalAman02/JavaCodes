package HashMap;

import java.util.*;
import java.util.Map;

public class H1_HashMap_Methods {
    static void HashMapMethods(){
        // -> syntax
        // here the data types of key and value can be anything , nothing is specific
        // Interface<class data type> name = new Class(inplementing this)<>();

        Map<String,Integer> mp = new HashMap<>();
//        HashMap<String,Integer> mp = new HashMap<>();   can also write this
        //--> adding elements
        mp.put("Aman", 21);
        mp.put("shekhar", 22);
        mp.put("Raghav", 32);
        mp.put("Shradhdha", 26);
        mp.put("Abhi", 19);
        // -> getting value of a key from the hashmap
        System.out.println(mp.get("Aman"));  // gives 21
        System.out.println(mp.get("rahul"));   // gives null as rahul not present
        // so get method give two types of value : **null and value if exist**

        // -> changing/ updating the value of a key:
        mp.put("Aman", 19);  // Aman -> 19
        System.out.println(mp.get("Aman"));
        // so here put dont insert another Aman but it updates it because it is already available
//        **so put : i> insertion,,,,ii> updation**

        // -> removing a pair from the HashMap
        System.out.println(mp.remove("Raghav")); // it only takes a key and remove it completely....
        // remove -> i> remove key and returns its value     ii> returns null if key not present
        System.out.println(mp.remove("Riya"));

        // -> check if a key is in the hashmp or or not
        System.out.println(mp.containsKey("Aman"));
        System.out.println(mp.containsKey("Raghav"));
        System.out.println(mp.containsValue(22));

        // -> adding a new key ONLY if new key is not already present
//        we can check first that map contain key or not if not then put the key
        if(!mp.containsKey("Yash")) mp.put("Yash",30);
        // but we already have a method for checking and adding
        mp.putIfAbsent("Yashika", 35);
        // -> to print the hashmap
        System.out.println(mp);
        // -> get all the key in hashmap
        System.out.println(mp.keySet());  // return a set of keys . key has data type of keys
        // -> get all the values of hashmap
        System.out.println(mp.values());  // return a collection of values . it has integer type as it contains integer
        // -> to get all the enteries of hashmap
        System.out.println(mp.entrySet());   // return a set of keys values pair . it has data type of Map.Entry<String,Integer>
        // -> traversing all the enteries of hashmap
        for (String key : mp.keySet()){    // we are iterating by the help of key ehich is String data type
            System.out.printf("the age of %s is %d \n", key, mp.get(key));
        }
        System.out.println();
        // can also print i another way , we can iterate by the help of entry data type, and traverse in mp.entryset
        for(Map.Entry<String,Integer> e : mp.entrySet() ){
            System.out.printf("Age of %s is %d \n",e.getKey(), e.getValue() );   // for getting from map we used mp.keySet(),mp.values() but here we r getting from entry so we used these
        }

        // also we dont hav to give the data type of iterator , we can give only var .java identifies it auto.   ..........
        System.out.println();
        for(var e : mp.entrySet()){
            System.out.printf("Age of %s is %d \n",e.getKey(), e.getValue() );
        }
    }
    public static void main(String[] args) {
        HashMapMethods();
    }
}

/*
- to access a value one must know its key
- Hashmap doesnt allow duplicate keys but allows dulicate values . that means A single key cant contain more than 1 value
  but more than one key can contain a single value
- hashmap allows null key also but only once and multiple null values.
- java Hashmap maintains no order
 */

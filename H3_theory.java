package HashMap;

public class H3_theory {

}
/*
there is a hash function which convert each key into a small integer and return it .
so for each H(ip1)[--(i.e. input 1) ]: there is op1.
so when same ip id called again it always return same op . so duplicate key never formed


A perfect hash function always produces an unique op for each ip'
But non perfect dont , i.e., ip1 ->op1,,ip1-> op2, ip3-> op1(also) so for ip1 and ip3 its COLlISION
so in the case of collision it occurs

        **GENERALLY USED HASH FUNCTION**
    1> Division method  ( h(k) = k%m)
    2> Mid Square function - ( h(k) = K*k )   then we took the middle as per the size of the hash table
    3> Digit Folding Method - ( i> first divide the digit in the segments then add all segment and then that mod with the size of table )
       i.e. k = k1,k2,k3,k4,.................,kn
            s = k1+k2+k3+k4+.................+kn
            H(k) = s%n
    4> Multiplication method - floor(M(kA mod 1))
       i.e. we first take the constant value A btw (0,1) then multiply the key k with A and then extract the fractional part of it and multiply
            the extracted value by M i,e, table count and then floor the value


since we can use linked list in place of node in bucket so that  to tackle colllision
but this will increase the time complexity even in optimal case , let lambda = n/N where n = enteries and N = bucket size
so
problem : As the no. of enteries increases , time complexity of map increases (lambda inc)
what we want : Minimise collisions, (Maintaion constamt time complexity)
solution : i> good hash function
           ii> more buckets/ capacity(usually double)
when to double the capacity: *  Load factor -> measure that decides when to fdouble the array size
            by default -> in java L.F. -> 75% of capacity

   -> threshold value - Acceptable no. of enteries before the capacity is doubled= lad factpr * capacity


Constructor in java hashmap:
    -> default-HashMap()
                Constructs an empty HashMap with the default initial capacity (16) and the default load factor (0.75).
             -HashMap(int initialCapacity)
                Constructs an empty HashMap with the specified initial capacity and the default load factor (0.75).
             -HashMap(int initialCapacity, float loadFactor)
                Constructs an empty HashMap with the specified initial capacity and load factor.
             -HashMap(Map<? extends K,? extends V> m)
                Constructs a new HashMap with the same mappings as the specified Map

 Collision resolution techniques - chaining- we already seen
       - open addressing - linear probes - (H(k)+i)%M
                         - Quadratic probing - (H(K)+i^2)%M
                         - Double Hashing - H(k,i) =H1(k) + H2(k) %M



 */

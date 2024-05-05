package BitManipulation;

public class Clear_ith_bit {
    public static int clearIthBit(int n, int i){
        int bitMask = ~(1<<i);
        return n& bitMask;
    }


    public static void main(String[] args) {
//        System.out.println(clearIthBit(10,1));    // for clearing
//        for updation
//        System.out.println(updateIthBit(10,2,1));

//        for clearing i bits
//        System.out.println(clear_I_bits(15,2));
        System.out.println(clearRange(10,2,4));

    }

    //     for update ith bit..............
    public static int setIthBit(int n, int i){
        int bitMask = 1<<i;
        return n| bitMask;

    }

    public static int updateIthBit(int n , int i, int newBit){
//        if(newBit ==0){
//            return clearIthBit(n,i);
//        }
//        else{
//            return setIthBit(n,i);
//        }

//        there is one more approach
        n= clearIthBit(n,i);
        int BitMask = newBit<<i;
        return n|BitMask;
    }

    public static  int clear_I_bits(int n, int i){
        int bitmask = (~0)<<i;
        return n& bitmask;
    }

    public static int clearRange(int n,int i,int j){
        int a= ((~0)<<(j+1));
        int b= (1<<i)-1;
        int bitmask = a|b;
        return n& bitmask;
    }
}

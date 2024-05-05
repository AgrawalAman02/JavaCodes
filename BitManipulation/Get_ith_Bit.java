package BitManipulation;

public class Get_ith_Bit {
    public static int ith_bit(int n, int i){
        int bitMask = 1<<i; //left shift by i time
        if((n& bitMask)== 0){
            return 0;
        }
        else{
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(ith_bit(10,1));  // as 10 = 1010;
    }
}

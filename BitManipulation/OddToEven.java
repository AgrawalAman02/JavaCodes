package BitManipulation;

public class OddToEven {
    public static void OddOrEven(int n){
        int bitMask = 1;
        if((n&bitMask)==0){
//            even no.
            System.out.println("Even Number");
        }
        else{
            System.out.println("ODD NUMBER ");
        }
    }
    public static void main(String[] args) {
        OddOrEven(3);
        OddOrEven(114);
    }
}

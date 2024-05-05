package array;

public class pairs {
    public static void main(String[] args) {
        int totalPairs=0;
        int arr[] = {2,4,6,8,10};
        for(int i=0; i<5;i++){
            for(int j=i+1;j<5;j++){
                System.out.print("("+arr[i]+","+arr[j]+")");
                totalPairs++;
            }
            System.out.println();
        }
        System.out.println("Total no. of pairs possible are :- "+totalPairs);


    }
}

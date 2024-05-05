package Stack;

import java.util.Stack;

public class A13_NextGreatestElement {

    static int[] nextGreater(int[] arr){
        // t.c. = O(n)
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[arr.length];
        res[arr.length-1]= -1;
        st.push(arr[arr.length-1]);
        for(int i =n-2;i>=0;i-- ){
            while(st.size()>0&&arr[i]>st.peek()){
                st.pop();
            }
            if(st.size()==0){
                res[i] = -1;
            }
            else{
                res[i] = st.peek();
            }
            st.push(arr[i]);

        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr= {1,3,2,1,8,6,3,4};
        // we can do it by array but it has some limitation i.e time complexity is O(n2) and sc = O(1)
        // if we got next max then store it in res otherwise it has -1
        int[] resi = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            resi[i]= -1;
            for(int j= i+1;j<arr.length;j++){
                if(arr[j]>arr[i]){
                    resi[i] = arr[j];
                    break;
                }
            }
        }
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for(int i = 0;i<arr.length;i++){
            System.out.print(resi[i]+" ");
        }
        int [] res = nextGreater(arr);
        System.out.println();
        for(int i = 0;i<arr.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}

package Stack;

import java.util.Stack;

public class A04_display {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
//        Stack<Integer> rt = new Stack<>();
//        while(st.size()>0){
//            rt.push(st.pop());
//        }
//        while(rt.size()>0){
//            System.out.print(rt.peek()+" ");
//            st.push(rt.pop());
//        }
//        System.out.println(st);

//        display using array
        int n = st.size();
        int [] arr = new int[n];
        for(int i = n-1;i>=0;i--){
            arr[i] = st.pop();
        }
        for(int i = 0;i<n;i++){
            System.out.print(arr[i] +" ");
            st.push(arr[i]);
        }



    }
}

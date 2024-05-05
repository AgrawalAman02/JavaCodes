package Queue;

import java.util.Stack;

// #push_Efficient code
public class Q11_QueueImp_using_Stk {

    public static class MyQueue{
        Stack<Integer> st = new Stack<>();
        Stack<Integer> rt = new Stack<>();
        public MyQueue(){

        }
        public void push(int x){
            st.push(x);
        }
        public int pop(){
            while(st.size()>1){
                rt.push(st.pop());
            }
            int item = st.pop();
            while(rt.size()>0){
                st.push(rt.pop());
            }
            return item;
        }
        public int peek(){
            while(st.size()>1){
                rt.push(st.pop());
            }
            int item = st.peek();
            while(rt.size()>0){
                st.push(rt.pop());
            }
            return item;
        }
        public boolean isEmpty(){
            if(st.size()==0) return true;
            return false;
        }
    }

    public static class MyQueue_PopEffy{
        Stack<Integer> st = new Stack<>();
        Stack<Integer> rt = new Stack<>();
        public MyQueue_PopEffy(){

        }
        public void push(int x){
            if(st.size()==0) st.push(x);
            else{
                while(st.size()>0) rt.push(st.pop());
                st.push(x);
                while(rt.size()>0) st.push(rt.pop());
            }
        }
        public int pop(){
            return st.pop();
        }
        public int peek(){
            return st.peek();
        }
        public boolean isEmpty(){
            if(st.size()==0) return true;
            return false;
        }
    }
    public static void main(String[] args) {
        // correct hh ji ;
    }
}


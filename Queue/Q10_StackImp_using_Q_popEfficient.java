package Queue;

import java.util.LinkedList;
import java.util.Queue;

// this have push order of n but pop and  peek order of 1
// we use reversal in push inspite of that used in pop and peek
public class Q10_StackImp_using_Q_popEfficient {
    public static class MyStack {
        Queue<Integer> q = new LinkedList<>();

        public MyStack() {
            //constructor
        }

        public void push(int x){
            if(q.size()==0) q.add(x);
            else{
                q.add(x);
                for(int i = 1;i<=q.size()-1;i++){
                    q.add(q.remove());
                }
            }
        }
        public int peek(){
            return q.peek();
        }
        public int pop(){
            return q.remove();
        }
        public boolean isEmpty(){
            if(q.size()==0){
                return true;
            }
            return false;
        }
        public void display(){
            System.out.println(q);
        }
    }
    public static void main(String[] args) {
        MyStack st = new MyStack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.display();
        st.pop();
        st.pop();
        st.display();

        // this is a leetcode question so there main function and display  not available
        // so here i made it by my own same in previous file so dispaly here is opp
        // so please ignore
    }
}

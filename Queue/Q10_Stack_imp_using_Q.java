package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Q10_Stack_imp_using_Q {

    public static class MyStack{
        Queue<Integer> q = new LinkedList<>();
        public MyStack(){
            //constructor
        }
        public void push(int x){
            q.add(x);
        }
        public int top(){  // peek
            for(int i = 1;i<=q.size()-1;i++){
                q.add(q.remove());
            }
            int item = q.peek();
            q.add(q.remove());
            return item;
        }
        public int pop(){
            for(int i = 1;i<=q.size()-1;i++){
                q.add(q.remove());
            }
            int item = q.peek();
            q.remove();
            return item;
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
    }
}

// s.c = O(1)
//  t.c. = push = O(1), peek = O(n) , pop = O(n)
// so this is push efficient as push t.c. is O(1)
// let see a pop efficient in other file

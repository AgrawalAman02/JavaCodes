package Stack;

import java.util.Stack;

public class A15_MinStack {

}

//here we are makin a class of minstack where we wamt to get the min element of stac in every  case
//so we will do in the below way . the sol is based  on the youtube video on leetcode
//below is done by h aving an extra space ie space compleity O(n)
class MinStaCK{
    Stack<Integer> st = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public MinStaCK(){
        //comstructor
    }

    public void push(int val){
        if(st.size()==0){
            st.push(val);
            min.push(val);

        }
        else{
            st.push(val);
            if(min.peek()<val) min.push(min.peek());
            else min.push(val);
        }
    }
    public void pop(){
        st.pop();
        min.pop();
    }
    public int top(){
        return st.peek();
    }

    public int getMin(){
        return min.peek();
    }
}

// Approach 2 :
// without having AN extra space


class MinStaCK2{
    Stack<Long> st = new Stack<>();
    long min =-1;
    public MinStaCK2(){
        //comstructor
    }

    public void push(int val){
        long x = (long) val;    // to play with our of bound of int
        if(st.size()==0){
            st.push(x);
            min = x;
        }
        else if(x>=min){
            st.push(x);
        }
        else if(x<min){
            st.push(2*x-min);    // taking the negative case also
            min = x;
        }
    }
    public void pop(){

        if(st.size()==0) return ;
        else if(st.peek()>=min) st.pop();
        else if(st.peek()<min){  // peek pr agr fake value pri ho toh
            // restore the old value
            long old = 2*min- st.peek();   // taking the negative case also
            min = old;
            st.pop();
        }
    }
    public int top(){

        if(st.size()== 0) return -1;
        long q = st.peek();
        if(q>=min) return (int)q;
        else if(q<min) return (int)min;
        return -1;
    }

    public int getMin(){
        if (st.size()==0) return -1;
        return (int)min;
    }
}
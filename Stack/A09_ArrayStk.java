package Stack;

public class A09_ArrayStk {

    static class Stack{
        int Max = 5;
        private int top = -1;
        private int[] stack = new int[Max];  // so that bahar se koio access n kr paye
        void push(int item){
            if(top == Max-1){
                System.out.println("...............Stack Overflow..............");
            }
            else{
                top ++;
                stack[top] = item;
            }
        }

        int pop(){
            if(top == -1){
                System.out.println(".........Stack UnderFlow........");
                return -1;
            }
            int item = stack[top];
            // as by default empty arr in java has 0 so we can do stack[top] = 0;
            top--;
            return item;
        }
        int peek(){
            if(top == -1) System.out.println(".........Stack UnderFlow........");
            return  stack[top];
        }
        int size() {
            if (top == -1) {
                System.out.println("stack is empty :) ");
                return 0;
            }
            else if (top == Max-1) {
                System.out.println("Stack is full :(");
                return Max;
            } else {
                return top + 1;
            }
        }
        void display(){
            System.out.println("Stack elements are :- ");
            for(int i = Max-1;i>=0;i--){
                if(i<=top){
                    System.out.println(stack[i]);
                }
                else {
                    System.out.println("*");
                }
            }
        }

        boolean isEmpty(){
            if(top==-1){
                return true;
            }
            return false;
        }
        boolean isFull(){
            if(top == Max-1){
                return true;

            }
            return false;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.display();
        System.out.println(st.isFull());
        System.out.println("the size is "+st.size());
        st.push(6);
        st.pop();
        st.pop();
        st.display();
        System.out.println(st.isEmpty());
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.display();
    }
}

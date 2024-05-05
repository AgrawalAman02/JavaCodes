package Stack;

public class A10_StkUsingLInkList {
    static class Node{    // user defined data type
        int data;
        Node next;
        Node(int data){
            this.data= data;
        }
    }

    static class LStack{    // User defined data structure
        private Node head = null;
        private int max = 5;
        private int size = -1;
        void push(int item){
//            if(size == max-1){
//                System.out.println("Stack overflow ");
//            }
//            Cant do because list has non fixed size this is benefit
            Node temp = new Node(item);
            temp.next = head;
            head = temp;
            size ++;
        }
        void  display(){
            Node temp = head;
            while(temp!= null){
                System.out.println(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
        int size(){
            return size;
        }

        int pop(){
           if(size == -1&& head == null){
               System.out.println("Stack underflow ");
               return -1;
           }
           else{
               int item = head.data;
                head = head.next;
                return item;
           }
        }
        int peek(){
            if(size == -1&& head == null){
                System.out.println("Stack underflow ");
                return -1;
            }
            int item = head.data;
            return item;
        }
        boolean isEmpty(){
            if(size==-1) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        LStack st = new LStack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.display();
//        System.out.println(st.isFull());
        System.out.println("the size is "+st.size());
        st.push(6);
        st.display();
        st.pop();
        st.pop();
        st.display();
        System.out.println(st.isEmpty());
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.push(2333);
        st.display();
    }
}

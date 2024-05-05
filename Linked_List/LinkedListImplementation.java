package Linked_List;

public class LinkedListImplementation {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    public static class Linkedlist{
        Node head = null;
        Node tail = null;
        void insertAtEnd(int item){
            Node temp = new Node(item);
            if(head == null){
                head = temp;
//                tail = temp;

            }
            else{
                tail.next= temp;
//                tail = temp;
            }
            tail = temp;   // if same condition is being used in both if and else then write that condition outside that

        }

        void display(){
            Node temp = head;    // if we use tail in place of temp then it also work
            System.out.print("\nSo your Linked List is here :-  ");
            while(temp!= null){
                System.out.print(temp.data+" -> ");
                temp = temp.next;

            }
            System.out.print("null");
        }

        int size(){
            // here we arre using tail inspite of temp so u see it will work .You can use temp also
            Node tail = head;
            int count = 0;
            while(tail != null){
                count++;
                tail = tail.next;
            }
            return count;
        }

        void insert_Beg(int item){
            Node temp = new Node(item);
            if(head == null){
//                temp.next= null;   // java auto set next to null
                head = tail = temp;   // since it is null list then we can use  ll.insertAtEnd(val); in place of  (head = tail = temp;)

            }
            else {
                temp.next = head;
                head = temp;

            }
        }

        void insert_At_pos(int pos,int item){
            Node tail = head;

            Node temp = new Node(item);
            if(pos==0){
                insert_Beg(item);
                return;
            }
            else if(pos == size()){
                insertAtEnd(item);
                return;
            }
            else if(pos<0|| pos > size()){
                System.out.println("\n Invalid entry . \"INDEX OUT OF BOUND\"");
                return;
            }
            else{
                for(int i = 0;i<pos-1;i++){
                    tail=tail.next;

                }
                temp.next= tail.next;
                tail.next = temp;
            }

        }

        void getAt(int pos){
            Node tail = head;
            int i= 0;
            if(pos<0|| pos > size()){
                System.out.println("\n Invalid entry . \"INDEX OUT OF BOUND\"");
                return;
            }
            while(i!=pos){
                i++;
                tail=tail.next;
            }
            System.out.println(tail.data);

        }

        void deleteAt(int pos){
            Node old = head;
            Node temp = head;
            int i = 0;
            while(i!= pos){
                old = temp;
                temp = temp.next;
                i++;
            }
            old.next= temp.next;
            temp.next = null;
            tail = temp;

            // or we can write temp.next = temp.next.next; if we dont use old and new concept and stop the loop at old node then it work easliy


        }

    }


    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        ll.insertAtEnd(45);
        ll.insertAtEnd(56);
        ll.insertAtEnd(11);
        ll.display();
        System.out.println("\nthe size of the list is -> " + ll.size());
        ll.insertAtEnd(76);
        ll.display();
        ll.insert_Beg(455);
        ll.display();
        ll.insert_Beg(986);
        ll.insertAtEnd(98);

        ll.display();
        ll.insert_At_pos(3,69);
        ll.display();
        ll.insert_At_pos(8,7777);
        ll.display();
        ll.insert_At_pos(0,101);
        ll.display();
        ll.insert_At_pos(11,101010);
        System.out.println("\n"+ll.head.data);
        ll.getAt(6);
        ll.deleteAt(6);
        ll.deleteAt(8);
        ll.display();
        System.out.println("\n"+ll.tail.data);


    }
}

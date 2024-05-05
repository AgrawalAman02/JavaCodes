package Linked_List;

public class LinkedList_PW_Basics {
    static Node head;

    public static void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void displayRecursive(Node head){

        if(head == null) {
            System.out.println("null");
            return;
        }

        System.out.print(head.data + " -> ");
        displayRecursive(head.next);
    }

    public static  void displayRecursiveReverse(Node head){
        if(head == null) {
            System.out.print("null  ");
            return;
        }

        displayRecursiveReverse(head.next);

        System.out.print(head.data + "  ");
    }

    public static void lengthIterarively(){
        Node temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp= temp.next;
        }
        System.out.println(" the length is -> " + count);
    }
    public static int count=0;
    public static void lengthRecursively(Node head){

        if(head == null){
            System.out.println("count is -> "+ count);
            return;
        }

        count++;
        lengthRecursively(head.next);
    }

    public static class Node{
        int data;  // value
        Node next;  // address of next node

        Node(int data){     // create a constructor so that during making object we provide the value.
            this.data = data;
        }

    }
    public static void main(String[] args) {
//        Lets create a object of node;
        Node a = new Node(5);
        head = a;
        // here we had created a object of node named a and assignes a value of its data as 5
//        System.out.println(a.next);  // null   --> as the next have by default null character
//        similarly we wil assigned the value to each other objects of node
        Node b = new Node(6);
        Node c = new Node(7);
        Node d = new Node(8);
        Node e = new Node(9);
        // 5 6 7 8 9
//        now i will link the a to b
        a.next = b;     // 5 -> 6 7 8 9
        b.next = c;     // 5 -> 6 -> 7 8 9
        c.next = d;     // 5 -> 6 -> 7 -> 8 9
        d.next = e;     // 5 -> 6 -> 7 -> 8 -> 9

        System.out.println(a.data);
        System.out.println(a.next);
        System.out.println(b);
        // so the value of a.next and b will print same as a.next have the address of b so b also results same value
        System.out.println(b.data);
        System.out.println();
        System.out.println(a.next.data);
//        a.next = b . so a.next.data = b.data
        System.out.println(a.next.next.data);  // c.data
        System.out.println(a.next.next.next.data);   // d.data
        System.out.println(a.next.next.next.next.data);  // e.data
        System.out.println(e.next); // gives output null as its by default next is null, we dont have to defne null like in c

//          inspite of doing all this above lengthy process we can simply make a loop , before i had to make a temp variable
        Node temp = a;   // here temp is not a node but it is a variable pointing to a node . if we had written Node temp = new Node() then ita a new node
        // so temp is also pointing to a so on sout(temp.data) gives the value of a
        System.out.println();


//        for(int i = 0;i<5;i++){
//            System.out.print(temp.data + " -> ");
//            temp = temp.next;
//        }
//        System.out.print("NULL");


//        or we can do by while loop  if we dont know the size of the list

//        while(temp!=null){
//            System.out.print(temp.data + " -> ");
//            temp = temp.next;
//        }
//        System.out.print("null");

//        or we can use function
        display();
        System.out.println();
        display();
//         here we can display it 2 times using function
//        but if i use it in main function then we cant print it 2 times as once temp goes to null then again running loop breaks instantly as temp is now null

        // now can we display it recursively;

        System.out.println();
        displayRecursive(head);

        System.out.println();
//         if we want to print the list in reverse order we cam easily doit by recursion
        displayRecursiveReverse(head);

//        Q.> Implement a method to find out the length of a Linked List (Itrative and Recursive)
        System.out.println();
        lengthIterarively();
        // by recursion
        lengthRecursively(head);
    }
}

/*
it is used to refer immediate parent class object
- to acess parent's properties
- to access parent's function
- to access parent's constructor
 */
package Oops;

public class Super {
    public static void main(String[] args) {
        Manager m = new Manager();

        System.out.println(m.dress);
    }
}
 class Boss{
    String dress;
    Boss(){
        System.out.println("boss constructor called");
    }
 }
 class Manager extends Boss{
    Manager(){
        super.dress = "formal";
        System.out.println("manager contructor called");
    }
 }
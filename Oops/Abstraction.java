package Oops;

public class Abstraction {




    //Hiding all the unnecessary deatils and showing he important parts to user
//- cannot create an instance of abstarct class
//- can have abstract / non - abstract methods
//- can have constructors
    public static void main(String[] args) {
//        Mustang myHorse = new Mustang();
        Horse h= new Horse();
        h.walk();
        h.eat();

        Chicken c = new Chicken();
        c.walk();
        c.eat();

//        animal a = new animal();   // we cant make a object of animal as it is abstracted , u can see red line on commenting out
    }
}
abstract class animal{   // abstract means we cant makes the object of class animal
    animal(){
        System.out.println("Animal constructor called");
    }
    void eat(){
        System.out.println("animal eat");
    }
    abstract void walk();  // means we cant define this method  or animal class dont able to know what this walk method do?
    // now its necessary for any other subclass if made to f=define walk function like below
}
class Horse extends animal{
    Horse(){
        System.out.println("Horse constructor called");
    }
    void walk(){
        System.out.println("walks on 4 legs");
    }
}
class Mustang extends Horse{
    Mustang(){
        System.out.println("Mustang constructor called");
    }
}
class Chicken extends animal{
    Chicken(){
        System.out.println("Chicken constructor called");
    }
    void walk(){
        System.out.println("walks on 2 legs");
    }
}
/*
 So the implementation of walk function depends on Horse and Chicken subclass but not on animal class
 also walk function don't need any parameter  in abstract;
*/

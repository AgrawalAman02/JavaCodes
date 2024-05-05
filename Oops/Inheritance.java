package Oops;

public class Inheritance {
    public static void main(String[] args) {
//        Fish shark = new Fish();
//        shark.swim();  // called from sub class fish
//        shark.eat();  // called from main class animal
// //        so fish can access all properties of animal class . this is called inheritance
        Dog tommy = new Dog();
        tommy.legs=4;
        System.out.println(tommy.legs);
        tommy.breed="High";
        System.out.println(tommy.breed);

        Lion jack = new Lion();
        jack.voice();
    }
}
// Base class
class Animal{
    String color;
    void eat(){
        System.out.println("eats");
    }

    void breathe() {
        System.out.println("breathes");
    }

}

// derived class/ sub class
class Fish extends Animal{
    int fins;
    void swim(){
        System.out.println("swims in water :)");
    }
}
// above is a example of single level inheritance
// below is the example of multi level inheritance
class Animals{
    String color;
    void eat(){
        System.out.println("eats");
    }

    void breathe() {
        System.out.println("breathes");
    }
}
class Mammals extends Animals{
    int legs;
}
class Dog extends Mammals{
    String breed;
}
class Lion extends Animals{
    void voice(){
        System.out.println("it Roars");
    }
}
class Cat extends Animals{
    void behaviour(){
        System.out.println("it scratches");
    }
}

// parent reference = child object
//   animal a = new mammel();   --> it is ok but vice versa not....<--

//here mammals , lion , cats are subclasses of Animals
// so more than one subclasses are ecample of MULTI LEVEL INHERITANCE

// next type is Hybrid inheritance
// i.e there r three subclass of Animals and for any or each subclass there are subsequent subclass;

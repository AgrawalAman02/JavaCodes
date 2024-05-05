package Oops;
// using different types of constucter for single work i,e creating object is one of its example
// there r two types of it
// 1. Compile time Polymorphism(static)
//    ~ method overloading
// 2. Run time polymorphism
//    ~ method overriding

public class Polymorphism {
    public static void main(String[] args) {
        /*
        Calculator calc = new Calculator();
        System.out.println(calc.sum(1,2));
        System.out.println(calc.sum(1.5f,2.7f));
        System.out.println(calc.sum(1,2,4));

        // for method overloading
         */
//        for overriding
        Deer d= new Deer();
        d.eat();
//        it calls from respective class inspite having same method name
    }
}
//when same methods having different type or no. of parameter then its overloading
 class Calculator{
    int sum(int a, int b){
        System.out.println("I os called");
        return a+b;
    }
    float sum(float a, float b){
        System.out.println("II is called");
        return a+b;

    }
    int sum(int a, int b, int c){
        System.out.println("III is called");
        return a+b;

    }
 }

// when parent and child classes both have the same function with a diferent definition . it is method overiding
class Animalss{
    void eat(){
        System.out.println("it eats");
    }
}
class Deer extends Animalss{
    void eat(){
        System.out.println("it eats but grass");
    }
}


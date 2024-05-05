package Oops;
//  class cant b private snd protected
public class OOPS {
    public static class amanclass{    // we can make class inside of oops class too....also can outside
        int name;
    }
    public static void main(String[] args) {
        Pen p1 = new Pen(); // created a pen object called p1
        p1.setColor("Blue");
        System.out.println(p1.getColor());  // using getColor to get the method of private attributes
        p1.setTip(5);
        System.out.println(p1.getTip());
        p1.setColor("yellow");
        System.out.println(p1.getColor());

        amanclass a2 = new amanclass();
        a2.name=6;


        Student aman = new Student();
        aman.percentage = 9.5f;
        System.out.println(aman.percentage);
        aman.calcPercentage(95,65,88);
        System.out.println(aman.percentage);

        BankAccount myAcc = new BankAccount();
        myAcc.username = "AmanKumar";
//        myAcc.password = "sdffs";  we cant do it as it is not visible in main function as it is private
        myAcc.setPasswod("abcdefgh"); // but we can able to change it here as we gave function public
//      but if we do setpassword private then we cant....
    }

}
 class BankAccount{
    public String username;
    private String password;
    public void setPasswod(String pwd){
        password= pwd;
    }
}
 class Pen{
   private String color;
    private int tip;

    int getTip(){
        return this.tip;  // this refers to tip of this class
    }
    String getColor(){
        return this.color;
    }
    void setColor(String newColor){  // it is setter
        color = newColor;  // here wew can also use this.color like in next method
    }
    void setTip(int newTip){
        this.tip= newTip;     // this.tip is more beneficial if in place of newTip we use the same name i.e. tip
        //then this.tip = tip where this tip refers tip of this class and tip will of that  method setTip
    }
}
class Student {
    String name;
    int age;
    float percentage; // cgpa

    void calcPercentage(int phy, int chem, int maths) {
        percentage = (phy + chem + maths) / 30;
    }
}


 
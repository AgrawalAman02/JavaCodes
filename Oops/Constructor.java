package Oops;

public class Constructor {
    public static void main(String[] args) {
        StudentA s1 = new StudentA();
        StudentA s2 = new StudentA("Aman");
        StudentA s3 = new StudentA(123);
        s1.name ="Aman";
        s1.roll=12;
        s1.password="abcdef";
        s1.marks[0]= 100;
        s1.marks[1]=90;
        s1.marks[2]=80;

//        for copy constructor{
        StudentA s4= new StudentA(s1);
        s4.password= "xyz";
        s1.marks[2]= 85;
        for(int i=0;i<3;i++){
            System.out.println(s4.marks[i]);
        }
//        }
    }
}
class StudentA{
    int roll;
    String name;
    String password;
    int[] marks;

//    COPY CONSTRUCTOR
    StudentA(StudentA s1){
        marks= new int[3];
        this.name = "Shekhar";
        this.roll= 14;
        this.marks = s1.marks;
//        here s1 is  copied as well as its marks so s4 marks[2] is now 80
        // now marks is changed of mafrks[2] of s1 so s4 dont have any change
//        s4.marks[2] will be 85 because array is passed by rerence so it marks changes then its marks at pos change so everywhere!
//        this is shallow copy.....
    }

//    deep copy constructor_🔻🔻

//    StudentA(StudentA s1){
//        marks = new int[3];
//        this.name = s1.name;
//        this.roll =s1.roll;
//        for(int i=0;i<marks.length;i++){
//            this.marks[i]= s1.marks[i];
//        }
//
//    }

    StudentA(){  // constructor
        marks= new int[3];
        System.out.println("constructor is called...");
    }

    StudentA(String name){
        marks= new int[3];
        this.name = name;
    }
    StudentA(int roll){
        marks= new int[3];
        this.roll = roll;
    }

}

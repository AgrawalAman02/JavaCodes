/*
Static keyword in java is used tom share the same variable or method of a given class.

-Properties
-Functions
-Blocks
-Nested Classes
 */
package Oops;

public class SStatic {
    public static void main(String[] args) {
        Studentt s1= new Studentt();
        s1.schoolName = "DAV";

        Studentt s2= new Studentt();
        System.out.println(s2.schoolName); // we set the school name for s1 but as it is static it will be same for every object

        Studentt s3 = new Studentt();
        s3.schoolName = " NPS"; // now if we change the school name , it will be changed for every object

        System.out.println(s1.schoolName);

    }

}
class Studentt{
    static int returnPercentage(int maths , int phy,int chem){  // static method
        return (maths + phy + chem)/3;  // as the method to calculate percentage is same for ecah student object so we use static keyword so that memoey dont consume much

    }
    String name;
    int roll;

    static String schoolName;

    void setName(String name){
        this.name =name;
    }
    String getName(){
        return this.name;
    }

}


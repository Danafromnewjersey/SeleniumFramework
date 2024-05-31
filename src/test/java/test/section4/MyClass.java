package test.section4;

import java.util.Locale;

public class MyClass {
    /*name of package should have lower case
    * name of Java Class should have first capital letter - test.section4.MyClass
    * package and public - are Java keywords*/
    //fields - parameters - variables - int, float, double, boolean, String
    //constructions
    //methods
   // int i = 5;
   // static int i;
//    static int i;
     int i = 5;
     String str = "Hello world";
    //you can initialize variable like: int i = 5;
    public MyClass() {
        //this is constructor - public
  //      i = 6;
//        this.i = 5;
    }
//    public MyClass (int i) {
////        this.i = i;
//        this.i = 5;
//    }
    public static void main (String[] args) {
        //TODO Auto-generated method stub
        //this is a main method, and its always static
//        MyClass myClass = new MyClass();//if you gonna add value inside the quotes(7), it's gonna execute using constructor with
        // argument value; We used polimorphysm, means different way
//        MyClass.initialize(); //- if we comment it its gonna use constructor MyClass
        MyClass myClass = new MyClass();//if we create new instance of the class,  it's resets all variables and become 0
        // (we will end up with 0 value for non static method)
        //      System.out.println(MyConstants.LONG_WAIT);
        //       System.out.println(EnumConstance.SUNDAY);
        myClass.stringCheck();
    }
        public void stringCheck () {
            str = str.concat("!!!");
            System.out.println(str);
            str = str.toUpperCase();
            System.out.println(str);
            str = str.toUpperCase(Locale.ROOT);
            System.out.println(str);
            str = str.substring(6, 11);
            System.out.println(str);
            boolean flag = str.equalsIgnoreCase("WORLD");
            System.out.println(flag);

            str = "5";
            int i = Integer.parseInt(str);
            System.out.println(i);

            i = 6;
            str = String.valueOf(i);
            System.out.println(i);

        }


  //      System.out.println(myClass.i);
//    }
    public MyClass initialize () {
        // public void - means this method doesn't return anything;
      //  System.out.println(i);
        //println means it will type from new line
//        i = 5;
        //lesson 23 - we added static keyword to this method and convert method int = i; to static int i;
        // using static method means we dont nee to create new instance to the class we can directly calling from the class. Remove
       // if you remove instance MyClass myClass = new MyClass(7);
        // and change MyClass.initialize(); - it will still work
        //        System.out.println(i); - this is a big difference between static method and non-static method
        i = 6;
        return this;
  //      System.out.println("I am in initialize method");
    }
}

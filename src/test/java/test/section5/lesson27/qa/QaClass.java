package test.section5.lesson27.qa;

public class QaClass {
    protected String str = "My String";

    protected void myMethod () {
       System.out.println("qa class my method");
   }
    protected void myMethod1 () {
        myMethod();
        System.out.println(str);
    }
}

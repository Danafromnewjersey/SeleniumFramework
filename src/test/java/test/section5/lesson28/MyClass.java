package test.section5.lesson28;

public class MyClass {
    public static void main (String [] arg){
        MyPrivateClass myPrivateClass = new MyPrivateClass();
        myPrivateClass.setStr("updated my string");
        myPrivateClass.printString();
 //       System.out.println(myPrivateClass.getStr());
    }
}

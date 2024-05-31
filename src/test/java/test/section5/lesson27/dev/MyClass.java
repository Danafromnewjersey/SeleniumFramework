package test.section5.lesson27.dev;

import test.section5.lesson27.qa.QaClass;

public class MyClass extends QaClass {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myClassMethod();
    }
    public void myClassMethod () {
       myMethod();
    }
}

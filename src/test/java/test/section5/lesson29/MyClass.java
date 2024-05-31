package test.section5.lesson29;

public class MyClass {

    public static void main (String [] arg) {

        Employee e = new FullTime();
        System.out.println("Full time employee salary is " + e.salary());
        FullTime f = new FullTime();
        f.myMethod();

        e = new Contractor();
        System.out.println("Contractor time employee salary is " + e.salary());

        System.out.println(Employee.designation());
        System.out.println(FullTime.designation());
        System.out.println(Contractor.designation());

        MyOverloadingClass myOverloadingClass = new MyOverloadingClass();
        myOverloadingClass.myMethod(5);
        myOverloadingClass.myMethod("my string");
        myOverloadingClass.myMethod("my string", 5);

    }
}

package test.section5.Lesson30;

public class MyClass {

    public static void main (String [] arg){
        Circle circle = new Circle("Red", 5.0);
        System.out.println(circle.info());

        Square square = new Square("Blue", 10.0);
        System.out.println(square.info());

    }
}

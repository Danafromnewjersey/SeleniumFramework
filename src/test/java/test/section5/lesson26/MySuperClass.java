package test.section5.lesson26;

public class MySuperClass {
    String superStr = "super class string";
    String commonStr = "super common string";

    public MySuperClass (String constructorStr) {
        System.out.println("super class constructor");
        System.out.println(constructorStr);
    }

    public void superClassMethod () {
        System.out.println("super class method");
    }

    protected void commonMethod() {
        System.out.println("super common method");
    }
}

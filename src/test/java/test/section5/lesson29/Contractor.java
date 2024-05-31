package test.section5.lesson29;

public class Contractor extends Employee {

    @Override
    int salary () {
        return base + 10000;
    }

    static String designation () {
        return "contractor";
    }
}

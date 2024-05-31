package test.section5.lesson32;

import java.io.File;
import java.io.FileNotFoundException;

public class MyClass {

    public static void main (String [] args) throws FileNotFoundException {

      File file = new File("c://myfile");
        try {
            System.out.println("random");
//            FileReader fr = new FileReader(file);
            throw new Exception("java exception");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("after exception");
      //if its showing error and highlighted in red it calls compile time exception
    }




    /*public static void main (String [] args) {
//        int myArray [] = {1, 2, 3};
//        System.out.println(myArray[3]);
        //example of run time exception Index 3 out of bounds for length 3; exit code 1
        FileReader fr = null;
      File file = new File("c://myfile");
        try {
             fr = new FileReader (file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();//complete info exception
         } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("after exception");
      //if its showing error and highlighted in red it calls compile time exception

    }*/
}

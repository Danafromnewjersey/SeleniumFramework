package test.section5.lesson25;

public class MyLesson25 {

    enum myChar {
        A,
        B
    }


    public static void main (String[] arg){
        MyLesson25 myLesson25 = new MyLesson25();
        myLesson25.switchCheck();
    }
    public void ifElseCheck () {
        boolean flag = false;
        String str = "myStr";

        if (str.equalsIgnoreCase("myStr") || flag){
            System.out.println("Im in if");
        } else {
            System.out.println("Im in else");
        }
    }
    public void forLoopCheck() {
        for (int i =0; i <5; i++) {
            System.out.println("i is " + i);
            if (i == 3) {
//              break; its gonna count to 3;
                continue;
            }
        }
    }
    public void forEachLoopCheck () {
        String [] myArray = {"a", "b", "c"};

        for (String str : myArray) {
            System.out.println(str);
            if (str.equalsIgnoreCase("b")){
                break;
            }
        }
    }
    public void whileLoopCheck () {
        int i = 5;
//it's gonna be indefinite loop
        while (i > 0) {
            System.out.println("I is " + i);
            i --;
            if (i == 3) {
                break;
            }
        }
    }
    public void switchCheck () {
        String str = "c";
        myChar nowChar = myChar.A;

        switch (nowChar) {
            case A:
                System.out.println(nowChar);
                break;
            case B:
                System.out.println(nowChar);
                break;
        }
    }
}

package test.section5.lesson28;

    public class MyPrivateClass {
        private  String str = "My String";

        private String getStr() {
            return  str;
        }

         public void setStr (String str) {
            this.str = str;
         }
         public void printString (){
             System.out.println(str);
         }
         private void myMethod () {
        System.out.println("my method");
         }
}

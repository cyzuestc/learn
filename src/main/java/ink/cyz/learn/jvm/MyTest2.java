package ink.cyz.learn.jvm;

public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.str);
    }
}
class MyParent2{
//    will be stored in the class's constant pool who invoke it in during compile
    public static final String str = "hello world";
    static {
        System.out.println("myParent2");
    }
}


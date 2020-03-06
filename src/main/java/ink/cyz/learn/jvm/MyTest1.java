package ink.cyz.learn.jvm;

public class MyTest1 {
    public static void main(String[] args) {
//        主动使用才会被初始化
//        子类初始化要求父类初始化
//        -XX:+TraceClassLoading
        System.out.println(MyChild1.str2);
    }
}
class MyParent1{
    public static String str = "hello world";
    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1{
    public static String str2 = "welcome";
    static {
        System.out.println("MyChild1 static block");
    }
}

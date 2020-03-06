package ink.cyz.learn.jvm;

import java.util.UUID;

public class MyTest3 {
    public static void main(String[] args) {
//        System.out.println(MyParent3.str);
        MyParent3[] p = new MyParent3[1];
        p[0] = new MyParent3();
        System.out.println(p.getClass());
        System.out.println(p[0].getClass());
    }
}

class MyParent3 {
//    will be stored in the class's constant pool who invoke it in during compile
    public static final String str = UUID.randomUUID().toString();
    static {
        System.out.println("myParent3 static code");
    }
}


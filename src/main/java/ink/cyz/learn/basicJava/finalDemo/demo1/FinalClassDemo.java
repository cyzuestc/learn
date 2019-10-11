package ink.cyz.learn.basicJava.finalDemo.demo1;

import ink.cyz.learn.basicJava.finalDemo.demo2.FatherClassDemo;

public final class FinalClassDemo {
    final String getName(){
        return "name";
    }
    //final method can be overloaded
    final String getName(String s){

    //protected variable cannot be seen by method from other packages
    //String Demo2FatherClassDemo = FatherClassDemo.name;
        return "getName";
    }

    private String name;

}

package ink.cyz.learn.basicJava.finalDemo.demo2;

public class ChildClassDemo extends FatherClassDemo{
    public ChildClassDemo() {
        //protected variable can be seen by subclasses
        name = super.name;
    }
}

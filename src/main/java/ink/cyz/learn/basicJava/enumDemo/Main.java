package ink.cyz.learn.basicJava.enumDemo;

public class Main {
    public static void main(String[] args) {
        USstate uSstate = USstate.AL;
        boolean is = uSstate.isNewEnglandState();
        System.out.println(is);
    }
}

package ink.cyz.learn.basicJava.enumDemo;

public enum USstate {
    AL("Alabama","Montgomery"),
    WY("Wyoming","Cheyenne");

    private String stateName;
    private String capitalCity;

    USstate(String s, String c){
        stateName = s;
        capitalCity = c;
    }

    final public String getStateName(){
        return stateName;
    }
    public boolean isNewEnglandState(){
        return this == WY;
    }
}



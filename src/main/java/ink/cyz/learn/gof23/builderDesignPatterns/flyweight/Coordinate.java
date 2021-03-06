package ink.cyz.learn.gof23.builderDesignPatterns.flyweight;

/**
 * DATE: 2019/5/15 17:56
 * AUTHOR: cyz.ink
 * 外部状态
 * UnSharedConcreteFlyWeight
 **/
public class Coordinate {
    private int x,y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {

        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

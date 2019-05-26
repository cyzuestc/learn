package ink.cyz.learn.gof23.builderDesignPatterns.flyweight;

public interface ChessFlyWeight {
    void setColor(String color);
    String getColor();
    void display(Coordinate coordinate);
}

class ConcreteChess implements ChessFlyWeight{
    private String color;

    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public void display(Coordinate coordinate) {
        System.out.println("Color:"+color);
        System.out.print("XLocation:"+ coordinate.getX());
        System.out.println(" YLocation:"+ coordinate.getY());

    }
}
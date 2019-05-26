package ink.cyz.learn.gof23.builderDesignPatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * DATE: 2019/5/15 18:05
 * AUTHOR: cyz.ink
 * 享元工厂类
 **/
public class ChessFlyWeightFactory {
    private static Map<String,ChessFlyWeight> map = new HashMap<>();

    public static ChessFlyWeight getChess(String color){
        if (map.get(color)!=null){
            return map.get(color);
        }else {
            ChessFlyWeight cfw = new ConcreteChess(color);
            map.put(color,cfw);
            return cfw;
        }
    }

}

package ink.cyz.learn.gof23.creationalDesignPatterns.prototype;

import java.io.*;
import java.util.Date;

/**
 * @Date 2019/5/4 13:05
 * @AUTHOR cyz.ink
 *
 * 通过序列化 反序列化来实现深拷贝
 **/
public class Client2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Date date = new Date();
        Sheep s1 = new Sheep("多利",date);
        /*
        使用反序列化
         */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        //序列化给数组
        oos.writeObject(s1);
        byte[] bytes = bos.toByteArray();
        //反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);

        Sheep sheep = (Sheep) ois.readObject();
        System.out.println(sheep);
    }
}

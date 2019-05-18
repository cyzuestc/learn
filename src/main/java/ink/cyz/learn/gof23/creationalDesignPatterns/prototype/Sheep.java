package ink.cyz.learn.gof23.creationalDesignPatterns.prototype;

import java.io.Serializable;
import java.util.Date;

/**
 * @Date 2019/5/4 12:57
 * @AUTHOR cyz.ink
 **/
public class Sheep implements Cloneable,Serializable {


    private String name;
    private Date birthday;

    public Sheep() {
    }

    public Sheep(String name, Date birthday) {

        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }



    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object o = super.clone();

        /**
         * 深拷贝
         * @return
         * @throws CloneNotSupportedException
         */

        Sheep s = (Sheep) o;
        s.birthday = this.birthday;
        s.name = this.name;

        return o;
    }
}

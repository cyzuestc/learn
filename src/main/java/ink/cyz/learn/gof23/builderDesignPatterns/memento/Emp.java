package ink.cyz.learn.gof23.builderDesignPatterns.memento;

/**
 * DATE: 2019/5/26 16:38
 * AUTHOR: cyz.ink
 **/
//源发器类
public class Emp {
    private String ename;
    private int age;
    private double salary;

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    //数据恢复
    public void recovery(EmpMemento mmt){
        this.ename = mmt.getEname();
        this.age = mmt.getAge();
        this.salary = mmt.getSalary();
    }

    public EmpMemento memento(){
        return new EmpMemento(this);
    }

    public Emp() {
    }

    public Emp(String ename, int age, double salary) {

        this.ename = ename;
        this.age = age;
        this.salary = salary;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

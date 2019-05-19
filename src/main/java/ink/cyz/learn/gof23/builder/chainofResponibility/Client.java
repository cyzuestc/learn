package ink.cyz.learn.gof23.builder.chainofResponibility;

/**
 * DATE: 2019/5/15 21:30
 * AUTHOR: cyz.ink
 **/
public class Client {
    public static void main(String[] args) {
        Leader l1 = new Director("张三");
        Leader l2 = new Manager("李四");
        Leader l3 = new GeneralManager("王五");

        l1.nextLeader = l2;
        l2.nextLeader = l3;

        LeaveRequest l = new LeaveRequest("1",31,"无理由");
        l1.handlerRequest(l);
    }

}

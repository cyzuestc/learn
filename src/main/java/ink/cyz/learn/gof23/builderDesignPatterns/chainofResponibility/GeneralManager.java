package ink.cyz.learn.gof23.builderDesignPatterns.chainofResponibility;

/**
 * DATE: 2019/5/15 21:26
 * AUTHOR: cyz.ink
 **/
public class GeneralManager extends Leader {

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handlerRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getLeaveDays()<30){
            System.out.println("员工："+leaveRequest.getEmpName()+
            "请假天数："+leaveRequest.getLeaveDays()+
            "理由："+leaveRequest.getReason());
            System.out.println("总经理："+this.name+"审批通过");
        }else {
            System.out.println("不批准");
        }
    }
}

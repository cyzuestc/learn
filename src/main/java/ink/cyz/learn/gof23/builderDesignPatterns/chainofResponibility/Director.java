package ink.cyz.learn.gof23.builderDesignPatterns.chainofResponibility;

/**
 * DATE: 2019/5/15 21:26
 * AUTHOR: cyz.ink
 **/
public class Director extends Leader {
    public static void main(String[] args) {
    }
    public Director(String name) {
        super(name);
    }

    @Override
    public void handlerRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getLeaveDays()<3){
            System.out.println("员工："+leaveRequest.getEmpName()+
            "请假天数："+leaveRequest.getLeaveDays()+
            "理由："+leaveRequest.getReason());
            System.out.println("主任："+this.name+"审批通过");
        }else {
            if (this.nextLeader!=null){
                this.nextLeader.handlerRequest(leaveRequest);
            }
        }
    }
}

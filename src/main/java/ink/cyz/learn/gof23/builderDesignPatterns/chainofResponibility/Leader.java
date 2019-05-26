package ink.cyz.learn.gof23.builderDesignPatterns.chainofResponibility;

/**
 * DATE: 2019/5/15 21:23
 * AUTHOR: cyz.ink
 **/
public abstract class Leader {
    protected String name;
    protected Leader nextLeader;

    public abstract void handlerRequest(LeaveRequest leaveRequest);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    public Leader(String name) {
        this.name = name;
    }
}

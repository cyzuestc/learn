package ink.cyz.learn.gof23.builder.iterator;

public interface MyIterator {
    void first();//将游标指向第一个
    void next();//将游标指向下一个
    boolean hasNext();

    boolean isFirst();
    boolean isLast();

    Object getCurrentObj();//获取游标当前对象
}

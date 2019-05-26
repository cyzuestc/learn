package ink.cyz.learn.gof23.builderDesignPatterns.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * DATE: 2019/5/19 10:43
 * AUTHOR: cyz.ink
 **/
public class ConcreteMyAggregate {
    private List<Object> list = new ArrayList<Object>();

    public ConcreteMyAggregate() {
    }

    public void addObject(Object obj){
        this.list.add(obj);
    }

    public void setList(List<Object> list){
        this.list = list;
    }

    public MyIterator createIterator(){
        return new ConcreteIterator();
    }

    private class ConcreteIterator implements MyIterator{

        private int cursor;
        @Override
        public void first() {
            cursor = 0;
        }

        @Override
        public void next() {
            if (hasNext()){
                cursor++;
            }
        }

        @Override
        public boolean hasNext() {
            return cursor<list.size();
        }

        @Override
        public boolean isFirst() {
            return cursor==0;
        }

        @Override
        public boolean isLast() {
            return cursor == list.size()-1;
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }
    }
}

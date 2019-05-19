package ink.cyz.learn.gof23.builder.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * DATE: 2019/5/19 10:43
 * AUTHOR: cyz.ink
 **/
public class ConcreteMyAggregate {
    private List<Object> list = new ArrayList<Object>();

    public ConcreteMyAggregate(List<Object> list) {
        this.list = list;
    }

    public void addObject(Object obj){
        this.list.add(obj);
    }

    public void setList(List<Object> list){
        this.list = list;
    }

    private class ConcreteIterator implements MyIterator{

        private int cursor;
        @Override
        public void first() {

        }

        @Override
        public void next() {

        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public boolean isFirst() {
            return false;
        }

        @Override
        public boolean isLast() {
            return false;
        }

        @Override
        public Object getCurrentObj() {
            return null;
        }
    }
}

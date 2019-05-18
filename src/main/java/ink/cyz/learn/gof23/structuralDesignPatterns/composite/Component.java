package ink.cyz.learn.gof23.structuralDesignPatterns.composite;

/**
 * @Date 2019/5/6 21:47
 * @AUTHOR cyz.ink
 **/
public interface Component {
    void operation();
}

interface Leaf extends Component{

}

interface Composite extends Component{
    void add(Component c);
    void remove(Component c);
    void operation();
}

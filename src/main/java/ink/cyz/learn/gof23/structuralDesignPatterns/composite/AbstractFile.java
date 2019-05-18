package ink.cyz.learn.gof23.structuralDesignPatterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019/5/6 21:50
 * @AUTHOR cyz.ink
 *
 * 杀毒架构
 **/
public interface AbstractFile {
    void killVirus();
}

class ImageFile implements AbstractFile{
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("图像文件"+name+",进行查杀");
    }
}

class TextFile implements AbstractFile{
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("TextFile"+name+",进行查杀");
    }
}

class VideoFile implements AbstractFile{
    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("VideoFile"+name+",进行查杀");
    }
}

class Folder implements AbstractFile{

    private String name;
//    定义容器,用来存放容器构建下的子节点
    private List<AbstractFile> list = new ArrayList<AbstractFile>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstractFile file){
        list.add(file);
    }
    public void remove(AbstractFile file){
        list.remove(file);
    }
    public AbstractFile getChild(int index){
       return list.get(index);
    }
    @Override
    public void killVirus() {
        System.out.println("文件夹"+name+",进行查杀");
        for(AbstractFile file :list){
            file.killVirus();
        }
    }
}
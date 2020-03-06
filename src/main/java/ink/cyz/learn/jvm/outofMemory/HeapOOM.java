package ink.cyz.learn.jvm.outofMemory;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
//    -Xms:10m -Xmx:10m
public static void main(String[] args) {
    List<HeapOOM> list = new ArrayList<>();
    while (true){
        list.add(new HeapOOM());
    }
}
}

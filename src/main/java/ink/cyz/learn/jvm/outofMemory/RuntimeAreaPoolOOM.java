package ink.cyz.learn.jvm.outofMemory;

import java.util.ArrayList;
import java.util.List;

public class RuntimeAreaPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}

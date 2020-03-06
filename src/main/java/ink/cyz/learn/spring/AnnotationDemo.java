package ink.cyz.learn.spring;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Arrays;

public class AnnotationDemo {
    @Test
    public void t() throws IOException {
        String path = "C:\\Users\\Administrator\\Desktop\\Friends8";
        File file = new File(path);
        File[] files = file.listFiles();
        Arrays.sort(files);
        int i = 1;
        for (File f : file.listFiles()){
            File newFile = new File(path,"S8E"+i++ +".mp4");
            System.out.println(f.renameTo(newFile));
        }
    }
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @interface  Length{
        int max();
        int min();
        String errorMsg();
    }
    public static String validate(Object o){
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field f : fields){
            if (f.isAnnotationPresent(Length.class)){
                Length length = f.getAnnotation(Length.class);
            }
        }
        return null;
    }


}

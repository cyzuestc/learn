package ink.cyz.use.spider;

import cn.hutool.http.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Util {
    public static void fengniaoPic(int id){
        String url = null;
        ArrayList<String> list = new ArrayList<>();
        String title = "";
        for (int i = 1; i < 10; i++) {
            url = String.format("http://bbs.fengniao.com/forum/%d_%d.html",id,i);
            new File("d:\\pic\\"+title+"\\"+url).mkdir();
            System.out.println(url);
            try {
                Document d = Jsoup.connect(url).get();
                title = d.title().isEmpty()? String.valueOf(new Date()) :d.title();
                File file = new File("d:\\pic\\"+title);

                Elements es = d.select(".postList .img img");
                if (es.isEmpty())break;
                for (Element e : es){
                    list.add(e.attr("src"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        for (int j = 0;j<list.size();j++){
            HttpUtil.downloadFile(list.get(j),"d:\\pic\\"+title+"\\"+id+"_"+
//                    "http://bbs.fengniao.com/forum/"+id+".html "
                    j+".jpg");
            System.out.println("下载进度:"+(j+1)+"/"+list.size());
        }
    }
}

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

public class PicDownload4 {

    public static void main(String[] args) {
//        String url = "http://bbs.fengniao.com/forum/10714188_1.html";
        String url = "http://bbs.fengniao.com/forum/10714357.html";
        try {
            Document d = Jsoup.connect(url).get();
            Elements es = d.select(".postList .img  img");
            for (Element e : es){
                System.out.println(e.attr("src"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

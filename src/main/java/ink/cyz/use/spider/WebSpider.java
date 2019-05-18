package ink.cyz.use.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @Date 2019/5/11 10:18
 * @AUTHOR cyz.ink
 **/
public class WebSpider {
    public static void main(String[] args) {
        int i = 1;
        try {
            for (i = 30; i < 100; i++) {
                String url = String.format("http://kktv.us/vod/1-%d.html",i);
                Document d = Jsoup.connect(url).get();
                Elements e =d.select(".thumb");
                for (Element element : e){
                    System.out.println(element.select("a").select("img").attr("alt"));
                    System.out.print("  ");
                    System.out.print(element.select("a").attr("href"));
                    System.out.print("  ");
                    System.out.print(element.select("a").select("img").attr("data-original"));
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

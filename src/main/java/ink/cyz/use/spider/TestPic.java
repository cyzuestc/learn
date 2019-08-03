package ink.cyz.use.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class TestPic {
    public static void main(String[] args) {
        String url = "https://y.qq.com/n/yqq/song/1572025_num.html?ADTAG=h5_playsong&no_redirect=1";
        String playUrl = "https://y.qq.com/portal/player.html";
        try {
            Document d = Jsoup.connect(url).get();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

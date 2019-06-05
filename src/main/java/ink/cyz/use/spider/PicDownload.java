package ink.cyz.use.spider;

import cn.hutool.Hutool;
import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2019/5/14 11:13
 * @AUTHOR cyz.ink
 **/
public class PicDownload {
    public static void main(String[] args) throws IOException {
//        String url = "http://m.lanwuzhe.com/app/audio/audio.html?id=1112";
        int i = 1;
        String url = String.format("http://xyq.netease.com/static/image/smiley/yxbq/%d.gif;",i);
//        String url = "http://music.163.com/song/1304754139/?userid=484774772";
        Map header= new HashMap<String,String>();
        header.put("Accept-Encoding","gzip, deflate");
//        header.put("Cookie","Hm_lpvt_bfc6c23974fbad0bbfed25f88a973fb0=1559715230; Hm_lvt_bfc6c23974fbad0bbfed25f88a973fb0=1559714980,1559715198");
//        header.put("Host","m.lanwuzhe.com");
        header.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/18.17763");
        header.put("Accept-Language", "zh-cn,zh;q=0.5");
        header.put("Accept-Charset", "  GB2312,utf-8;q=0.7,*;q=0.7");
        header.put("Connection", "keep-alive");

        Document d = Jsoup.connect(url).userAgent("Mozilla").headers(header).get();
        System.out.println(d.body());
        Elements e = d.select("#audioBox");
        System.out.println(e.toString());
    }
}

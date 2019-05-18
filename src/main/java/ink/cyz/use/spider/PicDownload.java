package ink.cyz.use.spider;

import cn.hutool.Hutool;
import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @Date 2019/5/14 11:13
 * @AUTHOR cyz.ink
 **/
public class PicDownload {
    public static void main(String[] args) throws IOException {
                String html =        "<div class=\"rich_media_content \" id=\"js_content\"> \n" +
                " <p style=\"text-align: center;\"><img class=\"rich_pages\" data-copyright=\"0\" data-s=\"300,640\" data-src=\"https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7N631hbStibHBYJicPyqRD2xdESFJHFq56Pb3e7swRwYPAN5CPib4Qnz0zUIHXd1pDFtVuXVN1BxJS2A/640?wx_fmt=jpeg\" data-type=\"jpeg\" style=\"\"></p>\n" +
                " <p style=\"text-align: center;\"><strong><span style=\"color: rgb(217, 33, 66);\">2019年郑州二模语文试题与答案</span></strong></p>\n" +
                " <p style=\"text-align: center;\"><img class=\"rich_pages\" data-s=\"300,640\" data-src=\"https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0J7o8XJDcsco1Nnvoeibqk2XibuRnkg4JZZSRRiblP0FB9jvfqicJ3GrXAA/640?wx_fmt=jpeg\" data-type=\"jpeg\" style=\"\"></p>\n" +
                " <p style=\"text-align: center;\"><img class=\"rich_pages\" data-s=\"300,640\" data-src=\"https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0DxI00uKnCbOaTrXGhSeGvWuiajTG9BQIesOanIes2ibA6kdWNB89gMLQ/640?wx_fmt=jpeg\" data-type=\"jpeg\" style=\"\"></p>\n" +
                " <p style=\"text-align: center;\"><img class=\"rich_pages\" data-s=\"300,640\" data-src=\"https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0yibWMbmxQ7DAMnbicmrTyAGoEicYPd03ibUR6HdLrb7aE3VXIDzJ7y9EIQ/640?wx_fmt=jpeg\" data-type=\"jpeg\" style=\"\"></p>\n" +
                " <p style=\"text-align: center;\"><img class=\"rich_pages\" data-s=\"300,640\" data-src=\"https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0wqvOVcs9rzVGIr99JBFlia78JeZ5Ek8jz8vQzuPEX3MlyWghicEgwxtw/640?wx_fmt=jpeg\" data-type=\"jpeg\" style=\"\"></p>\n" +
                " <p style=\"text-align: center;\"><img class=\"rich_pages\" data-s=\"300,640\" data-src=\"https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0MZMzQkJrN74x6ViaOBBNqicv9GJfERo3sWdUpE9Uk3phFncWMWeatuTw/640?wx_fmt=jpeg\" data-type=\"jpeg\" style=\"\"></p>\n" +
                " <p style=\"text-align: center;\"><img class=\"rich_pages\" data-s=\"300,640\" data-src=\"https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0j9mBH1ewV5Tiaqqp1mXk2VoDuwZBMYYZfW8lvAFw1Z91Jec1IjPOxAQ/640?wx_fmt=jpeg\" data-type=\"jpeg\" style=\"\"></p>\n" +
                " <p style=\"text-align: center;\"><img class=\"rich_pages\" data-s=\"300,640\" data-src=\"https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0KFSCcOcS6gl12pPWa48NicoconVJ2iaRuy81gTMHLPiapic5tfQFD1cyXw/640?wx_fmt=jpeg\" data-type=\"jpeg\" style=\"\"></p>\n" +
                " <p style=\"text-align: center;\"><img class=\"rich_pages\" data-s=\"300,640\" data-src=\"https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0m4QQZia5qUdWicBWhz81AbIhQTxjicmOS3o8UI2mJfS9yJAHkeicQAmzJA/640?wx_fmt=jpeg\" data-type=\"jpeg\" style=\"\"></p>\n" +
                " <p style=\"text-align: center;\"><img class=\"rich_pages\" data-s=\"300,640\" data-src=\"https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0ibnUnKDgjF2vicCoUD95Jr1UvKsoUtOuG5RFoibibSel8hWFIxC6Kn46WA/640?wx_fmt=jpeg\" data-type=\"jpeg\" style=\"\"></p>\n" +
                " <p style=\"text-align: center;\"><img class=\"rich_pages\" data-copyright=\"0\" data-s=\"300,640\" data-src=\"https://mmbiz.qpic.cn/mmbiz_jpg/cv64e2mCy7OGQCs7CPKpkDoSDtezuEj0iaAWY9icVghjkibXo6oGIfmtPaVFvJQwolSOC2XjFZ3FQ6fTETKXraeCQ/640?wx_fmt=jpeg\" data-type=\"jpeg\" style=\"\"></p>\n" +
                " <p style=\"text-align: center;\"><br></p> \n" +
                "</div>\n" +
                "\n" +
                "Process finished with exit code 0\n";
        String[] urls = {"https://mp.weixin.qq.com/s/QYLHMrU9l2ZHwWARiGpQkg" ,
                "https://mp.weixin.qq.com/s/BKphOXxXsKvNgYvvZwPFwg" ,
                "https://mp.weixin.qq.com/s/BKphOXxXsKvNgYvvZwPFwg" ,
                "https://mp.weixin.qq.com/s/B3EkS98zmWc52xrHyEZrOg" ,
                "https://mp.weixin.qq.com/s/wDRcPHZ-2RGXW-EkztfPRw" ,
                "https://mp.weixin.qq.com/s/Wtf1xhCDUs5_KBtTwCY3Gw" ,
                "https://mp.weixin.qq.com/s/nBivN6VuWyCL-MdkK418pA"};
        String url = urls[0];
//        Document d = Jsoup.connect(url).get();
        Document d =Jsoup.parse(html);
        Elements e = d.select(".rich_media_content").select("p");
        for (int i = 0;i<e.size();i++){
            String picUrl = e.get(i).select("img").attr("data-src");
            System.out.println(picUrl);
            HttpUtil.downloadFile(picUrl, FileUtil.file("d:/pic/1.jpeg"));
        }
    }
}

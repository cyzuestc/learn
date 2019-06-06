package ink.cyz.use.spider;

import cn.hutool.http.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Util {
    /**
     * 根据页码下载该页面所有帖子内的所有图片
     * @param pageIndex
     */
    public static void downloadFengniaoPicByPage(int pageIndex){
        Set<Integer> set = getFengniaoUrlsByPage(pageIndex);
        for (Integer num : set){
            downloadFengniaoPicById(num);
        }

    }

    /**
     * 根据页码下载该页所有帖子的Url
     * @param pageIndex
     * @return
     */
    public static Set<Integer> getFengniaoUrlsByPage(int pageIndex){
        Set <Integer> picSet = new HashSet<>();
        String url = null;

        try {
            url = String.format("http://bbs.fengniao.com/forum/forum_101_%d_lastpost.html",pageIndex);
            Document d = Jsoup.connect(url).get();
            Elements es = d.select(".txtlist li h3 a");
            for (Element e : es){
                picSet.add(Integer.valueOf(e.attr("href").substring(7,15)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(picSet);
        return picSet;
    }

    /**
     * 根据帖子Id下载帖子中的所有图片
     * @param id
     */
    public static void downloadFengniaoPicById(int id){
        String url = null;
        Set<String> picSet = new HashSet<>();
        String title = "";
        for (int i = 1; i < 3; i++) {
            url = String.format("http://bbs.fengniao.com/forum/%d_%d.html",id,i);
            new File("d:\\pic\\"+title+"\\"+url).mkdir();
            System.out.println(url);
            try {
                Document d = Jsoup.connect(url).get();
                title = d.title().isEmpty()? String.valueOf(new Date()) :d.title();
                //将不符合文件命名规则的符号替换掉
                title.replaceAll("[^\\u4E00-\\u9FA5A-Za-z0-9,.!]","");
                System.out.println(title);
                File file = new File("d:\\pic\\"+title);

                Elements es = d.select(".postList .img img");
                if (es.isEmpty())break;
                for (Element e : es){
                    picSet.add(e.attr("src"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        int index = 1;
        for (String picUrl : picSet){

            try {
                HttpUtil.downloadFile(picUrl,"d:\\pic\\" + title + "\\" + id + "_" + index + ".jpg");
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("下载进度:"+ index++ +"/"+picSet.size());
        }
    }
}

package ink.cyz.use.spider;

import cn.hutool.Hutool;
import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PicDownload3 {

    private static Logger logger = LoggerFactory.getLogger(PicDownload3.class);
    public static void main(String[] args) {

        for (int i = 65; i < 136; i++) {
            String url = String.format("http://xyq.netease.com/static/image/smiley/yxbq/%d.gif;",i);
            System.out.println(url);
            try{
                HttpUtil.downloadFile(url, FileUtil.file("d:/emoji/"+i+".gif"));
            }catch (Exception e){
                logger.error(e.toString());
            }

        }
    }
}

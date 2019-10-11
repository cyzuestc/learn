package ink.cyz.use.spider;

import cn.hutool.http.HttpUtil;
import ink.cyz.learn.leetcode.utils.ListNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Utils {

    public static ListNode getListNode(int[] array){
        if (array == null||array.length == 0)return null;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < array.length; i++) {
            ListNode next =new ListNode(array[i]);
            cur.next = next;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void  print(ListNode head){
        while (head != null){
            System.out.printf(head.val+"\t");
            head = head.next;
        }
        System.out.println();
    }
    public static void print(int[] arr,int i,int j){
        for (int k = i; k < j; k++) {
            System.out.printf(arr[k]+"\t");
        }
        System.out.println();
    }
    public static void print(int[] arr){
        for (int k = 0; k < arr.length; k++) {
            System.out.printf(arr[k]+"\t");
        }
        System.out.println();
    }
    public static void print(int[] arr,int i){
        for (int k = i; k < arr.length; k++) {
            System.out.printf(arr[k]+"\t");
        }
        System.out.println();
    }

    public static void print(String[] pre) {
        for (int i = 0; i < pre.length; i++) {
            System.out.printf(pre[i]+"\t");
        }
        System.out.println();
    }

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

    public static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf(board[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf(board[i][j]?"Q"+"\t":'.'+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf(board[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print(boolean[] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.printf(dp[i]+"\t");
        }
        System.out.println();
    }

    public static void print(Stack<int[]>[] dp) {
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == null || dp[i].isEmpty())continue;
            for (int[] arr : dp[i]){
                System.out.print(arr[0]+","+ arr[1]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print(char[] newCs,int index) {
        for (int i = 0; i < index; i++) {
            System.out.printf(newCs[i]+"\t");
        }
        System.out.println();
    }

    public static void print(long[] arr) {
        for (int k = 0; k < arr.length; k++) {
            System.out.printf(arr[k]+"\t");
        }
        System.out.println();
    }
}

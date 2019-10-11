package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author      : Zink
 * @ Date        : Created in 21:37 2019/8/21
 * @ Description : 设计一个支持以下两种操作的数据结构：void addWord(word)  bool search(word)
 * @ Version     : 1.0
 **/
public class Leetcode_211 {
    @Test
    public void t(){
        WordDictionary w = new WordDictionary();
        w.addWord("bad");
        System.out.println(w.root.toString());
        System.out.println(w.search("bad"));
    }

        class WordDictionary {
            WordMap root;
            public WordDictionary() {
                root  = new WordMap('0',false);
            }

            public void addWord(String word) {
                WordMap cur = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    //没有该字母
                    WordMap nextMap = cur.get(c);
                    if (nextMap == null){
                        WordMap wordMap = new WordMap(c,i == word.length()-1);
                        cur.childList[c-'a'] = wordMap;
                        cur.childSize = cur.childSize+1;
                       cur = wordMap;
                    //含有该字母
                    }else {
                        cur = nextMap;
                        if (i == word.length()-1){
                            cur.stop = true;
                        }
                    }

                }

            }

            public boolean search(String word) {
                return search(word,root);
            }

            private boolean search(String word, WordMap root) {
                if (word.isEmpty())return true;
                if (word.length() == 1){
                    WordMap nextMap = root.get(word.charAt(0));
                    return (word.charAt(0) == '.' && root.ontOfChildIsStop()) || (nextMap!= null&& nextMap.stop == true);
                }
                Character c = word.charAt(0);
                if (c == '.' ){
                    if (root.childSize == 0)return false;
                    for (int i = 0; i < root.childList.length; i++) {
                        if (root.childList[i] != null){
                            boolean res = search(word.substring(1),root.childList[i]);
                            if (res)return true;
                        }
                    }
                }else {
                    WordMap nextMap = root.get(c);
                    if (nextMap == null)return false;
                    else return search(word.substring(1),nextMap);
                }
                return false;
            }

        }
    private class WordMap {
        Character c ;
        int childSize ;
        WordMap[] childList;
        boolean stop;

        @Override
        public String toString() {
            return "WordMap{" +
                    "c=" + c +
                    ", childList=" + childList +
                    ", stop=" + stop +
                    '}';
        }

        public WordMap(Character c, boolean stop) {
            this.c = c;
            this.childList = new WordMap[26];
            this.stop = stop;
            this.childSize=0;
        }

        public WordMap get(Character c){
            if (c == '.')return null;
            return childList[c-'a'];
        }

        public boolean ontOfChildIsStop(){
            for (int i = 0; i < childList.length; i++) {
                if (childList[i]!= null && childList[i].stop)return true;
            }
            return false;
        }
    }


}

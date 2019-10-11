package ink.cyz.learn.leetcode;


import ink.cyz.learn.leetcode.utils.ListNode;
import ink.cyz.use.spider.Utils;
import org.junit.Test;

import java.util.*;

public class Leetcode_1169 {

    @Test
    public void t2(){
        String[] s1 = {"bob,649,842,prague","alex,175,1127,mexico","iris,164,119,paris","lee,991,1570,mexico","lee,895,1876,taipei","iris,716,754,moscow","chalicefy,19,592,singapore","chalicefy,820,71,newdelhi","maybe,231,1790,paris","lee,158,987,mexico","iris,803,691,milan","xnova,786,804,guangzhou","lee,734,1915,prague","bob,836,1904,dubai","iris,666,231,chicago","iris,677,1451,milan","maybe,860,517,toronto","iris,344,1452,bangkok","lee,664,463,frankfurt","chalicefy,95,1222,montreal","lee,293,1102,istanbul","maybe,874,36,hongkong","maybe,457,1802,montreal","xnova,535,270,munich","iris,39,264,istanbul","chalicefy,548,363,barcelona","lee,373,184,munich","xnova,405,957,mexico","chalicefy,517,266,luxembourg","iris,25,657,singapore","bob,688,451,beijing","bob,263,1258,tokyo","xnova,852,330,barcelona","xnova,589,837,budapest","lee,152,981,mexico","alex,893,1976,shenzhen","xnova,560,825,prague","iris,967,1119,guangzhou","alex,924,223,milan","chalicefy,212,1865,chicago","alex,443,537,taipei","bob,510,1923,madrid","bob,798,343,hongkong","iris,643,1703,madrid","bob,478,928,barcelona","maybe,75,1980,shanghai","iris,176,268,milan","maybe,560,587,milan","alex,406,776,istanbul","maybe,481,1504,munich","maybe,685,602,madrid","iris,678,788,madrid","chalicefy,36,1984,paris","iris,749,200,amsterdam","iris,406,433,bangkok","bob,777,542,taipei","maybe,230,1434,barcelona","iris,420,1818,zurich","lee,622,194,amsterdam","maybe,545,608,shanghai","xnova,201,1375,madrid","lee,432,520,dubai","bob,150,1634,singapore","maybe,467,1178,munich","iris,45,904,beijing","maybe,607,1953,tokyo","maybe,636,558,milan","bob,568,1674,toronto","iris,825,484,madrid","iris,951,930,dubai","bob,465,1080,taipei","chalicefy,16,176,rome","xnova,836,153,jakarta","bob,436,530,warsaw","alex,354,1328,luxembourg","iris,928,1565,paris","xnova,627,834,budapest","xnova,640,513,jakarta","alex,119,16,toronto","xnova,443,1687,taipei","chalicefy,867,1520,montreal","alex,456,889,newdelhi","lee,166,3,madrid","bob,65,1559,zurich","maybe,668,572,mexico","bob,402,922,montreal"};
        Arrays.sort(s1);
        String[] s2 = {"alex,119,16,toronto","alex,175,1127,mexico","alex,354,1328,luxembourg","alex,406,776,istanbul","alex,443,537,taipei","alex,456,889,newdelhi","alex,893,1976,shenzhen","alex,924,223,milan","bob,65,1559,zurich","bob,150,1634,singapore","bob,263,1258,tokyo","bob,402,922,montreal","bob,436,530,warsaw","bob,465,1080,taipei","bob,478,928,barcelona","bob,510,1923,madrid","bob,568,1674,toronto","bob,649,842,prague","bob,688,451,beijing","bob,777,542,taipei","bob,798,343,hongkong","bob,836,1904,dubai","chalicefy,16,176,rome","chalicefy,19,592,singapore","chalicefy,36,1984,paris","chalicefy,95,1222,montreal","chalicefy,212,1865,chicago","chalicefy,517,266,luxembourg","chalicefy,548,363,barcelona","chalicefy,820,71,newdelhi","chalicefy,867,1520,montreal","iris,25,657,singapore","iris,39,264,istanbul","iris,45,904,beijing","iris,164,119,paris","iris,176,268,milan","iris,344,1452,bangkok","iris,406,433,bangkok","iris,420,1818,zurich","iris,643,1703,madrid","iris,666,231,chicago","iris,677,1451,milan","iris,678,788,madrid","iris,716,754,moscow","iris,749,200,amsterdam","iris,803,691,milan","iris,825,484,madrid","iris,928,1565,paris","iris,951,930,dubai","iris,967,1119,guangzhou","lee,158,987,mexico","lee,166,3,madrid","lee,293,1102,istanbul","lee,373,184,munich","lee,432,520,dubai","lee,622,194,amsterdam","lee,664,463,frankfurt","lee,734,1915,prague","lee,895,1876,taipei","lee,991,1570,mexico","maybe,75,1980,shanghai","maybe,230,1434,barcelona","maybe,231,1790,paris","maybe,457,1802,montreal","maybe,467,1178,munich","maybe,481,1504,munich","maybe,545,608,shanghai","maybe,560,587,milan","maybe,607,1953,tokyo","maybe,636,558,milan","maybe,668,572,mexico","maybe,685,602,madrid","maybe,860,517,toronto","maybe,874,36,hongkong","xnova,201,1375,madrid","xnova,405,957,mexico","xnova,443,1687,taipei","xnova,535,270,munich","xnova,560,825,prague","xnova,589,837,budapest","xnova,627,834,budapest","xnova,640,513,jakarta","xnova,786,804,guangzhou","xnova,836,153,jakarta","xnova,852,330,barcelona"};
        Arrays.sort(s2);

        for (int i = 0; i < s1.length; i++) {
            if (!s1[i].equals(s2[i])){
                System.out.println(s1[i]);
                System.out.println(s2[i]);
                break;
            }
        }
        Utils.print(s1);
        Utils.print(s2);
        System.out.println(s1.length);
        System.out.println(s2.length);

    }
    @Test
    public void t(){
        String[] s = new String[]{"bob,689,1910,barcelona","alex,696,122,bangkok","bob,832,1726,barcelona","bob,820,596,bangkok","chalicefy,217,669,barcelona","bob,175,221,amsterdam"};
        System.out.println(invalidTransactions(s));
    }
    public List<String> invalidTransactions(String[] transactions) {
        List<Tsc> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        for (String s : transactions){
            list.add(new Tsc(s));
        }
        Collections.sort(list);
        System.out.println(list);
        String curName = "";
        for (int i = 0; i < list.size(); i++) {
            Tsc cur = list.get(i);
            boolean isValid = true;
            //new name
            if (!curName.equals(cur.name)){
                curName = cur.name;
                //check time
            }else {
                for (int j = i-1; j >=0 ; j--) {
                    Tsc last = list.get(j);
                    if (cur.time-last.time>60)break;
                    if (!last.name.equals(curName))break;
                    if (!last.city.equals(cur.city)){
                        if (last.isValid()){
                            last.setValid(false);
                            res.add(last.toString());
                        }
                        isValid = false;
                        break;
                    }
                }
            }
            if (cur.amount>1000 || !isValid){
                res.add(cur.toString());
                cur.setValid(false);
            }
        }
        return res;
    }

    class Tsc implements Comparable<Tsc>{
        String name;
        int time;
        int amount;
        String city;
        boolean valid;

        public boolean isValid() {
            return valid;
        }

        public void setValid(boolean valid) {
            this.valid = valid;
        }

        public Tsc(String s) {
            String[] args = s.split(",");
            this.name = args[0];
            this.time = Integer.parseInt(args[1]);
            this.amount = Integer.parseInt(args[2]);
            this.city = args[3];
            this.valid = true;
        }

        public Tsc(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
            this.valid = true;
        }

        @Override
        public String toString() {
            return this.name+","+this.time+","+this.amount+","+this.city;
        }


        @Override
        public int compareTo(Tsc o) {
            if(!this.name.equals(o.name)){
                return this.name.compareTo(o.name);
            }else {
                if (this.time != o.time){
                    return this.time-o.time;
                }else if (!this.city.equals(o.city)){
                    return this.city.compareTo(o.city);
                    }else {
                        return this.amount-o.amount;
                        }
            }
        }
    }
}

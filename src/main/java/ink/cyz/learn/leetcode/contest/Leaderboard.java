package ink.cyz.learn.leetcode.contest;

import org.junit.Test;

import java.util.*;

public class Leaderboard {
    @Test
    public void it(){
    }
    public int treeDiameter(int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int[] e : edges){
            if (map.get(e[0])==null)map.put(e[0],new ArrayList<>());
            if (map.get(e[1])==null)map.put(e[1],new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        dfs(map,edges[0][0],new HashSet<Integer>(),1);
        int nextNode = res;
        max = 0;
        res = 0;
        dfs(map,nextNode,new HashSet<Integer>(),1);
        return max;
    }

    int res = 0;
    int max = 0;
    private void dfs(Map<Integer, List<Integer>> map, int index,Set<Integer> visited,int len) {
        if (max<len){
            max = len;
            res = index;
        }
        for (int node : map.get(index)){
            if (visited.contains(node))continue;
            visited.add(node);
            dfs(map,node,visited,len+1);
        }
    }

}

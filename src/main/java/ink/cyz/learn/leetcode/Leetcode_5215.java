package ink.cyz.learn.leetcode;

import org.junit.Test;

public class Leetcode_5215 {
    @Test
    public void t(){
    }
    public int getMaximumGold(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                bfs(grid,visited,i,j,0);
            }
        }
        return res;
    }
    int res = 0;
    private void bfs(int[][] grid, boolean[][] visited, int i, int j, int total) {
        if (i<0||j<0||i==grid.length||j==grid[0].length)return;
        if (visited[i][j] || grid[i][j] == 0)return;
        res = Math.max(res,total+grid[i][j]);
        visited[i][j] = true;
        bfs(grid,visited,i-1,j,total+grid[i][j]);
        bfs(grid,visited,i+1,j,total+grid[i][j]);
        bfs(grid,visited,i,j-1,total+grid[i][j]);
        bfs(grid,visited,i,j+1,total+grid[i][j]);
        visited[i][j] = false;
    }
}

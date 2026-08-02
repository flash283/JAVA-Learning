package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class NumsIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';  // 标记已访问
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = '0';  // 入队就标记

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                    queue.offer(new int[]{x, y});
                    grid[x][y] = '0';  // 入队就标记
                }
            }
        }
    }
}

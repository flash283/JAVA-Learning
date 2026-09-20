package LanQiao;

import java.util.Scanner;

public class P1596 {
    static int n, m;
    static char[][] grid;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.next().toCharArray();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'W') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);
    }

    static void dfs(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 'W') return;
        grid[i][j] = '.';
        for (int d = 0; d < 8; d++) {
            dfs(i + dx[d], j + dy[d]);
        }
    }
}

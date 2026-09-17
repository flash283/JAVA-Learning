package LanQiao;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P1706 {
    static int n;
    static int[] path;
    static boolean[] used;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        path = new int[n];
        used = new boolean[n + 1];
        dfs(0);
        bw.flush();
    }

    static void dfs(int index) throws Exception {
        if (index == n) {
            for (int i = 0; i < n; i++) {
                bw.write(String.format("%5d", path[i]));
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;
            used[i] = true;
            path[index] = i;
            dfs(index + 1);
            used[i] = false;
        }
    }
}
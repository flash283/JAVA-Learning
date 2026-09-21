package LanQiao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1443 {
    static int n, m, startX, startY;
    static int[][] dist;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        startX=scan.nextInt()-1;
        startY=scan.nextInt()-1;

        dist=new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                dist[i][j]=-1;
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%-5d", dist[i][j]);
            }
            System.out.println();
        }
    }

    static void bfs(){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{startX,startY});
        dist[startX][startY]=0;

        while(!queue.isEmpty()){
            int []cur=queue.poll();
            int x=cur[0];
            int y=cur[1];
            for (int i=0;i<8;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}

package LanQiao;

import java.util.Scanner;

public class P1219 {
    static int n,count=0;
    static int[] pos;
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;


    public static void main(String[] args){
        Scanner sca=new Scanner(System.in);
        n=sca.nextInt();
        pos=new int[n];
        col=new boolean[n];
        diag1=new boolean[2*n];
        diag2=new boolean[2*n];
        dfs(0);
        System.out.println(count);
    }

    static void dfs(int row){
        if(row==n){
            count++;
            if(count<=3){
                for(int i=0;i<n;i++){
                    System.out.println(pos[i]+1+" ");
                }
                System.out.println();
            }
            return;
        }
        for(int j=0;j<n;j++){
            if(col[j]||diag1[row+j]||diag2[row-j+n]) continue;
            pos[row]=j;
            col[j] = true;
            diag1[row + j] = true;
            diag2[row - j + n] = true;
            dfs(row+1);
            col[j] = false;
            diag1[row + j] = false;
            diag2[row - j + n] = false;
        }

        }
    }


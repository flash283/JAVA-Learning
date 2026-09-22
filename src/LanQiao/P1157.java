package LanQiao;

import java.util.Scanner;

public class P1157 {
    static int n,r;
    static int[] num;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        r=sc.nextInt();
        num=new int[r];
        dfs(1,0);
    }

    static void dfs(int start,int count){
      if(count==r){
          for(int i=0;i<r;i++) {
              System.out.printf("%3d",num[i] );
          }
          System.out.println();
          return;
      }
      for(int i=start;i<=n;i++){
          num[count]=i;
          dfs(i+1,count+1);
      }
    }

}

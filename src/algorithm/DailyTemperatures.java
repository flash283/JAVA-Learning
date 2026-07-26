package algorithm;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
     /* int[]  answer=new int[temperatures.length];

      for(int i=0;i<temperatures.length;i++){
          for (int j=i+1;j<temperatures.length;j++){
              if(temperatures[j]>temperatures[i]){
                  answer[i]=j-i;
                  break;
              }else answer[i]=0;
          }
      }
      return answer;

      */
        //优化：
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();  // 存下标

        for (int i = 0; i < n; i++) {
            // 当前温度比栈顶下标对应的温度高 → 找到答案
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                answer[prev] = i - prev;
            }
            stack.push(i);
        }
        // 栈里剩下的都是找不到更高温度的，answer 默认就是 0，不用处理
        return answer;

    }

}

import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        int i = 0; 
        stack.push(i);
        
        for(i = 1; i < n; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int num = stack.pop();
                answer[num] = i-num;
            }
            stack.push(i);
            // System.out.println(Arrays.toString(answer));
        }
        // System.out.println("i : "  + i);
        while(!stack.isEmpty()){
            int num = stack.pop();
            answer[num] = i-num -1 ;
        }
        
        return answer;
    }
}
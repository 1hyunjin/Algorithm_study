import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int len = order.length;
        int[] num = new int[len];
        for(int i = 0; i < len; i++){
            num[i] = i+1;
        }
        // System.out.println(Arrays.toString(num));
        int s = 1;
        int idx = 0;
        while(true){
            if(idx >= len) break;
            if(s == order[idx]){
                idx++;
                s++;
            } else if(!stack.isEmpty() && stack.peek() == order[idx]){
                stack.pop();
                idx++;
            } else if(s <= len){
                stack.push(s);
                s++;
            } else {
                break;
            }
        }
        return idx;
    }
}
import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = {};
        Deque<Integer> deq = new ArrayDeque<>();
        int i = 0;
        while(i < arr.length){
            int num = arr[i];
            if(deq.isEmpty()){
                deq.add(num);
                i++;
            }
            else{
                if(deq.peekLast() < num){
                    deq.add(num);
                    i++;
                }
                else {
                    deq.pollLast();
                }
            }
        }
        stk = new int[deq.size()];
        i = 0;
        while(!deq.isEmpty()){
            stk[i] = deq.poll();
            i++;
        }
        return stk;
    }
}
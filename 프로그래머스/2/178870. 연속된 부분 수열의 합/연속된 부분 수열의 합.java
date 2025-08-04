import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int N = sequence.length;
        int[] sumArr = new int[N+1];
        for(int i = 1; i <= N; i++){
            sumArr[i] = sumArr[i-1] + sequence[i-1];
        }

        int left = 0; 
        int right = 0;
        int start = 0;
        int end = 0;
        
        int minLen = Integer.MAX_VALUE;
        
        while(right < N+1){
            int diff = sumArr[right] - sumArr[left];
            if(diff < k){
                right++;
            }
            if(diff > k){
                left++;
            }
            if(diff == k){
                if(minLen > right-left){
                    minLen = right-left;
                    start = left;
                    end = right-1;
                }
                left++;
            }
        }
        int[] answer = {start, end};
        return answer;
    }
}
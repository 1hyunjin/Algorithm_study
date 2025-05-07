import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        int len = diffs.length;
        int max = 0; 
        for(int i = 0; i < len; i++){
            max = Math.max(max, diffs[i]);
        }
        long result = Integer.MAX_VALUE;
        long start = 1;
        long end = max;
        
        while(start <= end){
            long mid = (start+end)/2;
            // System.out.println("mid : " + mid);
            long sum = 0; 
            for(int j = 0; j < len; j++){
                long diff = diffs[j];
                if(diff <= mid){
                    sum += times[j];
                }
                else if(diff > mid){
                    long miss = diff-mid;
                    long plus = times[j] + times[j-1];
                    sum += miss * plus;
                    sum += times[j];
                }
            }
            // System.out.println("sum : " + sum);
            if(sum > limit){
                // end = mid-1;
                start = mid+1;
            }
            else {
                // System.out.println("limit 안에 할 수 있음");
                end = mid-1;
                // start = mid+1;
                answer = Math.min(answer, (int)mid);
            }
        }
        return answer;
    }
}
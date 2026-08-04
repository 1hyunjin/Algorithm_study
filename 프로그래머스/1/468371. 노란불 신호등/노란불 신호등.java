import java.util.*;
class Solution {
    public int solution(int[][] signals) {
        int answer = -1;
        long cycle = 1; // 전체 주기
        for(int i = 0; i < signals.length; i++){
            long sum = signals[i][0] + signals[i][1] + signals[i][2]; // G + Y + R
            cycle = (cycle*sum)/gcd(sum, cycle);
            // System.out.println(cycle);
        }
        for(int t = 1; t <= cycle; t++){
            boolean flag = true;
            for(int signal = 0; signal < signals.length; signal++){
                int G = signals[signal][0];
                int Y = signals[signal][1];
                int R = signals[signal][2];
                long sum = G + Y + R;
                // 노란불 주기
                long yTime = (t-1)%sum;
                if(yTime >= G && yTime < (G+Y)){
                    flag = true;
                }
                else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                return t;
            }
        }
        return answer;
    }
    public static long gcd(long a, long b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}
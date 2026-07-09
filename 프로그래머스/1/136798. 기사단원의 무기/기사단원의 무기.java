import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            int num = i;
            int cnt = 0;
            for(int j = 1; j <= Math.sqrt(num); j++){
                if(num % j == 0){
                    if(num/j == j){
                        cnt+=1;
                    }
                    else{
                        cnt+=2;
                    }
                }
            }
            if(cnt <= limit){
                answer += cnt;
            }
            else{
                answer += power;
            }
        }
        return answer;
    }
}
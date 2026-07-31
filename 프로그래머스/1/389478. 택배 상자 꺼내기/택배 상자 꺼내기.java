import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int row = (num-1)/w; // 행
        int tmp = (num-1)%w;
        int col = 0;
        if(row % 2 == 0){ // 1 2 3 4 5 6
            col = tmp;
        }
        else{
            col = w-1-tmp;
        }
        int next = 0; 
        while(true){
            if(row % 2 == 1){   // 홀수행 -> 짝수행
                next = num + (2*col + 1);
            }
            else{   // 짝수행 -> 홀수행
                next = num + 2*(w-col)-1;
            }
            if(num > n){
                break;
            }
            num = next;
            answer++;
            row++;
        }
        return answer;
    }
}
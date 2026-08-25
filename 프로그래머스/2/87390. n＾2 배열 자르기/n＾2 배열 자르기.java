import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int cha = (int)right - (int)left;
        int[] answer = new int[cha+1];
        for(int i = 0; i <= cha; i++){
            long row = (left+i)/n;
            long col = (left+i) % n;
            long max = Math.max(row, col);
            answer[i] = (int)max+1;
        }
        return answer;
    }
}
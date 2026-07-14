import java.util.*;
class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.reverse();
        String tmp = sb.toString();
        answer = new int[tmp.length()];
        for(int i= 0; i < tmp.length(); i++){
            answer[i] = tmp.charAt(i)-'0';
        }
        return answer;
    }
}
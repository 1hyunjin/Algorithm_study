import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int cnt = 0;
        int zeroCnt = 0;
        while(!s.equals("1")){
            String tmp = s.replace("0", "");
            int len = s.length() - tmp.length();
            String reverse = Integer.toString(tmp.length(), 2);
            zeroCnt += len;
            s = reverse;
            cnt++;
        }
        answer = new int[]{cnt, zeroCnt};
        return answer;
    }
}
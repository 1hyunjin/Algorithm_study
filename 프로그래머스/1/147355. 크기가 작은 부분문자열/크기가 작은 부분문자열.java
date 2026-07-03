import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        StringBuilder sb = new StringBuilder();
        sb.append(t.substring(0, len));
        if(Long.parseLong(sb.toString()) <= Long.parseLong(p)){
            answer++;
        }
        int right = len;
        while(right < t.length()){
            sb.deleteCharAt(0);
            sb.append(t.charAt(right));
            if(Long.parseLong(sb.toString()) <= Long.parseLong(p)){
                answer++;
            }
            right++;
        }
        return answer;
    }
}
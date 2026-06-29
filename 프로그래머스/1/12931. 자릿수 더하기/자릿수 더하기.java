import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String s = ""+n;
        
        for(int i = 0; i < s.length(); i++){
            int num = s.charAt(i)-'0';
            answer += num;
        }

        return answer;
    }
}
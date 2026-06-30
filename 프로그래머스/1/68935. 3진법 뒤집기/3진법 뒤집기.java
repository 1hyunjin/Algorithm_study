import java.util.*;
class Solution {
    public int solution(int n) {
        String s = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        int answer = Integer.parseInt(sb.toString(), 3);
        return answer;
    }
}
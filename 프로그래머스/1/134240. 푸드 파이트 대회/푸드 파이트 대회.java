import java.util.*;
class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < food.length; i++){
            int cnt = food[i];
            int moc = food[i]/2;
            for(int j = 0; j < moc; j++){
                sb.append(i);
            }
        }
        answer += sb.toString();
        answer += 0;
        answer += sb.reverse().toString();
       return answer;
    }
}
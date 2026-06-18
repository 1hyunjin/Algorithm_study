import java.util.*;

class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        for(int i = 0; i < myString.length(); i++){
            String s = myString.substring(0, i+1);
            if(s.endsWith(pat)){
                answer = s;
            }
        }
        return answer;
    }
}
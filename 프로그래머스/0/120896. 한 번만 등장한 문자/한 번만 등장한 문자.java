import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        TreeMap<Character, Integer> map = new TreeMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char key : map.keySet()){
            int val = map.get(key);
            if(val == 1){
                answer += key;
            }
        }
        return answer;
    }
}
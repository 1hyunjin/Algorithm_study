import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        int len = participant.length;
        for(int i = 0; i < len; i++){
            String name = participant[i];
            
            map.put(name, map.getOrDefault(name, 0)+1);
        }
        for(int i = 0; i < completion.length; i++){
            String complete = completion[i];
            if(map.containsKey(complete)){
                int cnt = map.get(complete);
                map.put(complete, cnt-1);
            }
        }
        for(String key : map.keySet()){
            if(map.get(key) == 1){
                return key;
            }
        }
        
        return answer;
    }
}
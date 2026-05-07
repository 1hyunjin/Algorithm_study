import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < participant.length; i++){
            String name = participant[i];
            map.put(name, map.getOrDefault(name, 0)+1);
        }
        for(int i = 0; i < completion.length; i++){
            String name = completion[i];
            if(map.containsKey(name)){
                int val = map.get(name);
                map.put(name, val-1);
                if(val-1 == 0){
                    map.remove(name);
                }
            }
        }
        String answer = "";
        for(String key : map.keySet()){
            answer = key;
            break;
        }
        return answer;
    }
}
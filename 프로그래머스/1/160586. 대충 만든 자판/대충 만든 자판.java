import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < keymap.length; i++){
            String s = keymap[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(map.containsKey(c)){
                    int val = map.get(c);
                    int min = Math.min(val, j+1);
                    map.put(c, min);
                }
                else{
                    map.put(c, j+1);
                }
            }
        }
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            boolean isMatch = true;
            String target = targets[i];
            for (int j = 0; j < target.length(); j++) {
                if (map.containsKey(target.charAt(j))) {
                    sum += map.get(target.charAt(j));
                }
                else{
                    isMatch = false;
                    break;
                }
            }
            if(isMatch){
                answer[i] = sum;
            }
            else{
                answer[i] = -1;
            }
        }
        return answer;
    }
}
import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }
        for(int i = 0; i < callings.length; i++){
            int idx = map.get(callings[i]);
            String before = players[idx-1];
            players[idx-1] = callings[i];
            players[idx] = before; 
            map.put(callings[i], idx-1);
            map.put(before, idx);
            // System.out.println(Arrays.toString(players));
        }
        return players;
    }
}
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
         int answer = 1;

        Map<String, Integer> type = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (!type.containsKey(clothes[i][1])) {
                type.put(clothes[i][1], 1);
            }else {
                type.put(clothes[i][1], type.get(clothes[i][1]) + 1);
            }
        }


        for (String key : type.keySet()) {

            answer *= type.get(key) + 1;

        }
        answer -= 1;

        return answer;
    }
}
import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(int i =0; i < arr.length; i++){
            int n = arr[i];
            for(int j = 0; j < n; j++){
                list.add(n);
            }
        }
        answer = new int[list.size()];
        for(int i =0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
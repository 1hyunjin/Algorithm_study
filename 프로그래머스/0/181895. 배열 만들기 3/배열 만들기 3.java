import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(int i =0; i < intervals.length; i++){
            int s = intervals[i][0];
            int e = intervals[i][1];
            for(int j = s; j <= e; j++){
                list.add(arr[j]);
            }
        }
        answer = new int[list.size()];
        for(int i =0; i< list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        List<Integer>[] graph= new List[201];
        for(int i = 0; i <= 200; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i =0; i < score.length; i++){
            int avg = (score[i][0] + score[i][1]);
            graph[avg].add(i);
        }
        int rank = 1;
        for(int i = 200; i >= 0; i--){
            if(graph[i].size() > 0){
                for(int j = 0; j < graph[i].size(); j++){
                    answer[graph[i].get(j)] = rank;
                }
                rank += graph[i].size();
            }
        }
        return answer;
    }
}
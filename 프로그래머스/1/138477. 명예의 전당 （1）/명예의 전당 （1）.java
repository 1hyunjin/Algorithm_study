import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < score.length; i++){
            if(pq.size() < k){
                pq.offer(score[i]);
            }
            else{
                if(score[i] > pq.peek()){
                    pq.poll();
                    pq.offer(score[i]);
                }
            }
            list.add(pq.peek());
        }
        answer = new int[list.size()];
        for(int i =0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
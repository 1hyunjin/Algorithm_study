import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int i = 0; i < score.length; i++){
            pq.offer(score[i]);
        }
        int cnt = 0;
        while(!pq.isEmpty()){
            // System.out.println(pq.size());
                cnt++;
                if(cnt == m){
                    // System.out.println("마지막 사과!" + pq.peek());
                    answer += (pq.poll() * m);
                    cnt = 0;
                }
                else{
                    pq.poll();
                }
        }
        return answer;
    }
}
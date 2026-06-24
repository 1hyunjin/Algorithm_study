import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            queue.offer(scoville[i]);
        }
        boolean isHot = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(queue.size() > 1){
                int first = queue.poll();
                int second = queue.poll();
                if(first >= K){
                    return answer;
                }
                int nxt = first + (second*2);
                queue.offer(nxt);
            }
            else{
                if(queue.poll() >= K){
                    return answer;
                }
                else{
                    isHot = false;
                }
            }
            answer++;
        }
        
        return -1;
    }
}
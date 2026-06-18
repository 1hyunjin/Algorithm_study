import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};
        Deque<Integer> deq = new ArrayDeque<>();
        for(int i =0; i < arr.length; i++){
            deq.offer(arr[i]);
        }
        for(int i = 0; i < query.length; i++){
            int index = query[i];
            int size = deq.size();
            if(i % 2 == 0){
                int turn = deq.size()-index-1;
                for(int j = 0; j < turn; j++){
                    deq.pollLast();
                }
            }
            else{
                for(int j = 0; j < index; j++){
                    deq.pollFirst();
                }
            }
        }
        int s = deq.size();
        answer = new int[s];
        for(int i = 0; i < s; i++){
            answer[i] = deq.poll();
        }
        
        return answer;
    }
}
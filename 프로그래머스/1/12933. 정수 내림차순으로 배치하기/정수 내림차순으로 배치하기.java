import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = "";
        s += n;
        System.out.println(s);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b-a);
        for(int i = 0; i < s.length(); i++){
            queue.offer(s.charAt(i)-'0');
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            sb.append(queue.poll());
        }
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}
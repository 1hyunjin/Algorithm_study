import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int len = words.length;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(begin);
        boolean[] visited = new boolean[len];
        
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s = 0; s < size; s++){
                String cur = queue.poll();
                if(cur.equals(target)){
                    return time;
                }
                for(int i = 0; i < len; i++){
                    if(!visited[i]){
                        if(change(cur, words[i])){
                            queue.offer(words[i]);
                            visited[i] = true;
                        }
                    }
                }
            }
            time++;
        }
        
        return answer;
    }
    public boolean change(String cur, String next){
        int cnt = 0;
        for(int i = 0; i < cur.length(); i++){
            if(cur.charAt(i) != next.charAt(i)){
                cnt++;
            }
        }
        if(cnt > 1){
            return false;
        }
        return true;
    }
}
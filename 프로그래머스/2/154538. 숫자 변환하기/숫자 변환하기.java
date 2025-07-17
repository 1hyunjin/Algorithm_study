import java.io.*;
import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
            boolean[] visited = new boolean[1000000*3];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(x);
            visited[x] = true;
            int cnt = 0; 
            boolean isMatch = false;
            out:while(!queue.isEmpty()){
                int size = queue.size();
                for(int s = 0; s < size; s++){
                    int cur = queue.poll();
                    if(cur == y){
                        isMatch = true;
                        break out;
                    }
                    int nx = cur+n;
                    int nx1 = cur*2;
                    int nx2 = cur*3;
                    if(!visited[nx] && nx <= y){
                        queue.add(nx);
                        visited[nx] = true;
                    }
                    if(!visited[nx1] && nx1 <= y){
                        queue.add(nx1);
                        visited[nx1] = true;
                    }
                    if(!visited[nx2] && nx2 <= y){
                        queue.add(nx2);
                        visited[nx2] = true;
                    }
                }
                cnt++;
            }
            if(!isMatch){
                return -1;
            }else{
                return cnt;
            }
    }
}
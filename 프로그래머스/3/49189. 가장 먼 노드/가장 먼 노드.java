import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int m = edge.length;
        List<Integer>[] graph = new List[m+1];
        for(int i = 0; i <= m; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i =0; i < m; i++){
            int a= edge[i][0];
            int b= edge[i][1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        boolean[] visited = new boolean[m+1];
        visited[1] = true;
        int max = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i =0; i < graph[1].size(); i++){
            int v = graph[1].get(i);
            queue.offer(v);
            visited[v] = true;
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            int dist = 0;
            max = size;
            for(int s = 0; s < size; s++){
                int cur = queue.poll();
                for(int v : graph[cur]){
                    if(!visited[v]){
                        visited[v] = true;
                        queue.offer(v);
                    }
                }
            }
            dist++;
        }
        
        return max;
    }
}
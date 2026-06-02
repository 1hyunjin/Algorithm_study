import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0,0));
        visited[0][0] = true;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int time = 0;
        out:while(!queue.isEmpty()){
            int size = queue.size();
            for(int s = 0; s < size; s++){
                Point cur = queue.poll();
                if(cur.x == n-1 && cur.y == m-1){
                    answer = time+1;
                    break out;
                }
                for(int d = 0; d < 4; d++){
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || maps[nx][ny] == 0) continue;
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            time++;
        }
        
        return answer;
    }
    public static class Point{
        int x;
        int y;
        public Point(int x, int y ){
            this.x = x;
            this.y = y;
        }
    }
}
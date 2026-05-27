import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0 ;i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[N][M];
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0,0));
        visited[0][0] = true;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        int exit = 0;
        out:while(!queue.isEmpty()){
            Point cur = queue.poll();
            if(cur.x == N-1 && cur.y == M-1){
                exit = 1;
                break out;
            }
            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1 && !visited[nx][ny]){
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }

        }
        System.out.println(exit);

    }
    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
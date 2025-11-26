import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] ddx = {-1, -1, 1, 1};
    static int[] ddy = {-1, 1, 1, -1};
    static int N, M;
    static int[][] map;
    static boolean[][] visited; // 구름이 생겼었는지 확인하는 방문 배열
    static Queue<Point> queue, cloud;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        queue = new ArrayDeque<>();
        cloud = new ArrayDeque<>();
        for (int i = N - 2; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                queue.offer(new Point(i, j));
            }
        }
        for (int i = 0; i < M; i++) {
            visited = new boolean[N][N];
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            // 여기서 구름 움직이고 +1 물 주고
            while (!queue.isEmpty()) {
                Point cur = queue.poll();
                int rx = cur.x+dx[dir]*s;
                int ry = cur.y+dy[dir]*s;
                int nx = ((rx%N)+N)%N;
                int ny = ((ry%N)+N)%N;
                map[nx][ny]+=1; // 물 주고
                visited[nx][ny] = true; // 구름 생겨따
                cloud.offer(new Point(nx, ny));
            }
            // 대각선 확인하고 물 채우고
            while (!cloud.isEmpty()) {
                Point cur =cloud.poll();
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + ddx[d];
                    int ny = cur.y + ddy[d];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (map[nx][ny] > 0) {
                       cnt++;
                    }
                }
                map[cur.x][cur.y] += cnt;
            }
            // 구름 만들어지지 않았던 곳 & 물이 2이상인 칸 모두 구해서 구름 생기게 하고
            makeCloud();
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += map[i][j];
            }
        }
        System.out.println(result);
    }

    public static void makeCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] >= 2) {
                    map[i][j] -=2;
                    queue.offer(new Point(i, j));
                }
            }
        }
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

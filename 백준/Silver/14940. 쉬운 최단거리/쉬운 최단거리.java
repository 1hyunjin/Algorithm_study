import java.io.*;
import java.util.*;

class Main {
    static int N, M, sx, sy;
    static int[][] map, graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        sx = 0;
        sy = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    sx = i;
                    sy = j;
                }
            }
        }
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    graph[i][j] = 0;
                }
                else{
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        graph[sx][sy] = 0;
        bfs();
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(sx, sy));
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx < 0 || nx >= N || ny < 0 ||  ny >= M || map[nx][ny] == 0) continue;
                if(nx == sx && ny == sy) continue;
                if (graph[nx][ny] > graph[cur.x][cur.y] + 1) {
                    graph[nx][ny] = graph[cur.x][cur.y]+1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == Integer.MAX_VALUE) {
                    sb.append(-1).append(" ");
                }
                else{
                    sb.append(graph[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
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
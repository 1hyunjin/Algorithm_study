import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static int start, end;
    static int result, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = 0;
        max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    visited = new boolean[N][M];
                    start = map[i][j];
                    bfs(i, j);
                }
            }
        }
        System.out.println(result);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void bfs(int nowi, int nowj) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(nowi, nowj, 0));
        visited[nowi][nowj] = true;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.dist >= max) {
                if (cur.dist > max) {
                    result = start + map[cur.x][cur.y];
                } else {
                    result = Math.max(result, start + map[cur.x][cur.y]);
                }
                max = cur.dist;
            }
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == 0) continue;

                queue.add(new Point(nx, ny, cur.dist + 1));
                visited[nx][ny] = true;
            }
        }
    }

    public static class Point {
        int x;
        int y;
        int dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}

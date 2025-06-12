import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        boolean isPossible = false;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                isPossible = true;
                break;
            }
            int nx = cur.x + 1;
            int ny = cur.y + 1;
            if (nx < N && map[nx][cur.y] == 1 && !visited[nx][cur.y]) {
                queue.add(new Point(nx, cur.y));
                visited[nx][cur.y] = true;
            }
            if (ny < M && map[cur.x][ny] == 1 && !visited[cur.x][ny]) {
                queue.add(new Point(cur.x, ny));
                visited[cur.x][ny] = true;
            }
        }
        if (isPossible) {
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
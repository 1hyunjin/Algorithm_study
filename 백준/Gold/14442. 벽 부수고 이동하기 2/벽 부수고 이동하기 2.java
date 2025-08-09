import java.io.*;
import java.util.*;

public class Main {
    static int N,M, K;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][K+1];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0, 0));
        visited[0][0][0] = true;
        int turn = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point cur = queue.poll();
                if (cur.x == N - 1 && cur.y == M - 1) {
                    System.out.println(turn);
                    return;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    // 벽이 아니고 방문하지 않은 곳이면 방문
                    if (map[nx][ny] == 0 && !visited[nx][ny][cur.bomb]) {
                        visited[nx][ny][cur.bomb] = true;
                        queue.add(new Point(nx, ny, cur.bomb));
                    }
                    if (cur.bomb < K) {
                        if (map[nx][ny] == 1 && !visited[nx][ny][cur.bomb + 1]) {
                            visited[nx][ny][cur.bomb+1] = true;
                            queue.add(new Point(nx, ny, cur.bomb + 1));
                        }
                    }
                }
            }
            turn++;
        }
        System.out.println(-1);
    }
    public static class Point{
        int x;
        int y;
        int bomb;

        public Point(int x, int y, int bomb) {
            this.x = x;
            this.y = y;
            this.bomb = bomb;
        }
    }
}
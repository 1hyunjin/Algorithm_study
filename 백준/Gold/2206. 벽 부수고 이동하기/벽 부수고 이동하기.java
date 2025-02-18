import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static boolean isExit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        isExit = false;

        int answer = bfs();
        if (isExit) {
            System.out.println(answer);
        }
        else {
            System.out.println(-1);
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0, 0));
        visited[0][0][0] = true ;

        int turn = 1;

        out: while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point cur = queue.poll();
                if (cur.x == N-1 && cur.y == M-1) {
                    isExit = true;
                    return turn;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        continue;
                    }
                    // 벽이 아니고 방문하지 않은 곳이면 이동
                    if (map[nx][ny] == 0 && !visited[nx][ny][cur.bomb]) {
                        visited[nx][ny][cur.bomb] = true;
                        queue.add(new Point(nx, ny, cur.bomb));
                    }
                    // 벽이고 벽을 부순적이 없다면 벽을 부수고 이동
                    else if (cur.bomb == 0 && map[nx][ny] == 1 && !visited[nx][ny][cur.bomb+1]) {
                        visited[nx][ny][cur.bomb+1] = true;
                        queue.add(new Point(nx, ny, cur.bomb+1));
                    }
                }
            }
            turn++;
        }
        return -1;
    }

    public static class Point {
        int x;
        int y;
        int bomb;

        public Point(int x, int y, int bomb) {
            this.x = x;
            this.y = y;
            this.bomb = bomb;
        }

        @Override
        public String toString() {
            return "Point{ " + this.x + " , " + this.y + " , " + this.bomb + " }";
        }
    }
}
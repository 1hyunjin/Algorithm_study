import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int landNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(landNum, i, j); // 섬 나누기?
                    landNum++;
                }
            }
        }
        // 상,하,좌,우 중에 하나라도 0이 있으면 bfs를 돌리기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    makeBridge(i, j);
                }
            }
        }
        System.out.println(min);
    }

    static void makeBridge(int i, int j) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(i, j));
        visited = new boolean[N][N];
        int land = map[i][j];

        int len = 0;
        out:
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point cur = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 0) {
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    } else if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] != 0 && map[nx][ny] != land) {
                        min = Math.min(min, len);
                        break out;
                    }
                }
            }
            len++;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void bfs(int landNum, int i, int j) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(i, j));
        visited[i][j] = true;
        map[i][j] = landNum;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = landNum;
                }
            }
        }
    }
    public static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
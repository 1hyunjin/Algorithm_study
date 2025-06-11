import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int M, N, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        cnt = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    map[j][k] = 1;
                }
            }
        }
        visited = new boolean[M][N];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    list.add(bfs(i, j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(list);
        for (int i = 0; i < cnt; i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static int bfs(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        int space = 1;
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] == 1) {
                    continue;
                }
                queue.add(new Point(nx, ny));
                visited[nx][ny] = true;
                space++;
            }
        }
        return space;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{ " + this.x + " , " + this.y + " }";
        }
    }
}
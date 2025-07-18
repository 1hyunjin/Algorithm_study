import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int N, M;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }
        int result = bfs(0, 0);
        System.out.println(result);
    }

    public static int bfs(int x, int y) {
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2) {
                return o1.cnt - o2.cnt;
            }
        });
        pq.offer(new Point(0, 0, 0));
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.cnt;
            }
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if (map[nx][ny] == 1) {
                        pq.offer(new Point(nx, ny, cur.cnt + 1));
                        visited[nx][ny] = true;
                    }
                    else{
                        pq.offer(new Point(nx, ny, cur.cnt));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return 0;
    }
    public static class Point{
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
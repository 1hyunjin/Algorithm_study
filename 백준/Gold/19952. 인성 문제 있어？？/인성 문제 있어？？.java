import java.io.*;
import java.util.*;

class Main {
    static int h, w, o, f, sx, sy, tx, ty;
    static StringBuilder sb;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            o = Integer.parseInt(st.nextToken());   // 장애물 개수
            f = Integer.parseInt(st.nextToken());   // 초기 힘
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            tx = Integer.parseInt(st.nextToken());
            ty = Integer.parseInt(st.nextToken());

            map = new int[h + 1][w + 1];
            for (int i = 0; i < o; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = Integer.parseInt(st.nextToken());
            }
            if (bfs(sx, sy)) {
                sb.append("잘했어!!").append("\n");
            }
            else{
                sb.append("인성 문제있어??").append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static boolean bfs(int sx, int sy) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(sx, sy, f));
        boolean[][] visited = new boolean[h + 1][w + 1];
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.x == tx && cur.y == ty) {
                return true;
            }
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx > 0 && nx <= h && ny > 0 && ny <= w && !visited[nx][ny] &&
                        (map[nx][ny] - map[cur.x][cur.y]) <= cur.power && cur.power > 0) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, cur.power-1));
                }
            }
        }
        return false;
    }

    public static class Point {
        int x;
        int y;
        int power;

        public Point(int x, int y, int power) {
            this.x = x;
            this.y = y;
            this.power = power;
        }
    }
}
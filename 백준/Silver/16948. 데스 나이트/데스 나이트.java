import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());

        int[] dx = {-2, -2, 0, 0, 2, 2};
        int[] dy = {-1, 1, - 2, 2, -1, 1};

        int[][] map = new int[N + 1][N + 1];
        boolean[][] visited = new boolean[N + 1][N + 1];
        if (sx == ex && sy == ey) {
            System.out.println(0);
            return;
        }

        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(sx, sy));
        visited[sx][sy] = true;
        int time = 0;
        boolean isArrive = false;
        out:while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point cur = queue.poll();
                if (cur.x == ex && cur.y == ey) {
                    isArrive = true;
                    break out;
                }
                for (int d = 0; d < 6; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx < 0 || nx > N || ny < 0 || ny > N || visited[nx][ny]) continue;
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            time++;
        }
        if (isArrive) {
            System.out.println(time);
        }
        else{
            System.out.println(-1);
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
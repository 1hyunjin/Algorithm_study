import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.') {
                    if(!bfs(i, j)){
                        System.out.println("1");
                        return;
                    }
                }
            }
        }
        System.out.println("0");
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static boolean bfs(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx > R-1 || ny < 0 || ny > C-1 || map[nx][ny] == 'X') continue;
            queue.offer(new Point(nx, ny, i));
        }
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.x == x && cur.y == y) {
                break;
            }
            boolean isExit = false;
            for (int d = 0; d < 4; d++) {
                if (cur.dir == 0 && d == 1) continue;
                if (cur.dir == 1 && d == 0) continue;
                if (cur.dir == 2 && d == 3) continue;
                if (cur.dir == 3 && d == 2) continue;

                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx > R-1 || ny < 0 || ny > C-1 || map[nx][ny] == 'X') continue;
                queue.offer(new Point(nx, ny, d));
                isExit = true;
            }
            if(!isExit){
                return false;
            }
        }
        return true;
    }

    public static class Point {
        int x;
        int y;
        int dir;

        public Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<Point> list;
    static Point[] result;
    static int ans;
    static boolean[] isSelected;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    list.add(new Point(i, j));
                }
            }
        }
        result = new Point[3];
        isSelected = new boolean[list.size()];
        queue = new ArrayDeque<>();
        ans = 0;
        comb(0, 0);
        System.out.println(ans);
    }
    public static void comb(int idx, int cnt) {
        if (cnt == 3) {
            makeWall(result);
            return;
        }
        if (idx == list.size()) {
            return;
        }
        isSelected[idx] = true;
        result[cnt] = list.get(idx);
        comb(idx+1, cnt+1);
        isSelected[idx] = false;
        comb(idx+1, cnt);
    }
    static int[][] tmp;
    static Queue<Point> queue;
    public static void makeWall(Point[] result) {
        tmp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < result.length; i++) {
            tmp[result[i].x][result[i].y] = 1;
        }
        // 바이러스 퍼트림
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }
        bfs();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 0) {
                    cnt++;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void bfs() {
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && tmp[nx][ny] == 0) {
                    tmp[nx][ny] = 2;
                    queue.add(new Point(nx, ny));
                }
            }
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

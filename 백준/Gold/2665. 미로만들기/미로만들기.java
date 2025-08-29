import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int N;
    static int[][] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }
        tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[i][j] = Integer.MAX_VALUE;
            }
        }
        tmp[0][0] = 0;
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2) {
                return o1.cnt-o2.cnt;
            }
        });
        pq.add(new Point(0, 0, 0));
        visited[0][0] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                int a = (map[nx][ny] == 0 ? 1 : 0);
                if (tmp[nx][ny] > tmp[cur.x][cur.y] + a) {
                    tmp[nx][ny] = tmp[cur.x][cur.y] + a;
                    pq.offer(new Point(nx, ny, tmp[nx][ny]));
                }
            }
        }
        System.out.println(tmp[N-1][N-1]);
    }
    public static class Point{
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}

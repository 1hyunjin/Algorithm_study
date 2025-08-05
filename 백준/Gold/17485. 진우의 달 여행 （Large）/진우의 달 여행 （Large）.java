import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dy = {-1, 0, 1};
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2) {
                return o1.dist - o2.dist;
            }
        });
        int[][][] best = new int[N][M][3];
        int INF = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(best[i][j], INF);
            }
        }
        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                int nj = j + dy[d];
                if(nj < 0 || nj >= M) continue;
                int dist = map[0][j] + map[1][nj];
                if (dist < best[1][nj][d]) {
                    best[1][nj][d] = dist;
                    pq.offer(new Point(1, nj, d, dist));
                }
            }
        }
        int answer = INF;
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (cur.dist > best[cur.i][cur.j][cur.dir]) {
                continue;
            }
            if (cur.i == N - 1) {
                answer = cur.dist;
                break;
            }
            for (int d = 0; d < 3; d++) {
                if (cur.dir == d) {
                    continue;
                }
                int ni = cur.i + 1;
                int nj = cur.j + dy[d];
                if(nj < 0 || nj >= M) continue;
                int ndist = cur.dist + map[ni][nj];
                if (ndist < best[ni][nj][d]) {
                    best[ni][nj][d] = ndist;
                    pq.offer(new Point(ni, nj, d, ndist));
                }
            }
        }
        System.out.println(answer);
    }

    public static class Point {
        int i;
        int j;
        int dir;
        int dist;

        public Point(int i, int j, int dir, int dist) {
            this.i = i;
            this.j = j;
            this.dir = dir;
            this.dist = dist;
        }
    }
}
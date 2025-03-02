import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int N;
    static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][N];
        int num = 2;

        // 섬 나누기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j, num);
                    num++;
                }
            }
        }

        // 하나의 섬에서 빈칸으로만 갔을 때 dist 구하고 이 때 next 구간이 0이 아니고 나랑 다른 값일 때,
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    visited = new boolean[N][N];
                    bfs2(i, j);
                }
            }
        }

        System.out.println(min);
    }

    public static void bfs2(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y, map[x][y]));
        visited[x][y] = true;
        int dist = 0;

        out:while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                Point cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                        if (map[nx][ny] == 0) {
                            queue.add(new Point(nx, ny, cur.landNum));
                            visited[nx][ny] = true;
                        } else if (map[nx][ny] != cur.landNum) {
                            min = Math.min(min, dist);
                            break out;
                        }
                    }
                }
            }
            dist++;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void bfs(int x, int y, int num) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y ,num));
        visited[x][y] = true;
        map[x][y] = num;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    map[nx][ny] = num;
                    queue.add(new Point(nx, ny ,num));
                }
            }
        }
    }

    public static class Point{
        int x;
        int y;
        int landNum;

        public Point(int x, int y, int landNum) {
            this.x = x;
            this.y = y;
            this.landNum = landNum;
        }

        @Override
        public String toString() {
            return "Point { " + this.x + " , " + this.y + " , " + this.landNum + "번 섬  }";
        }
    }
}
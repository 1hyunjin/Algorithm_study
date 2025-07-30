import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N][M];
        visited = new boolean[N][M];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int X = Integer.parseInt(br.readLine());

        if(map[0][0] != map[N-1][M-1]){
            System.out.println("DEAD");
            return;
        }
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        boolean isExit = false;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                isExit = true;
                System.out.println("ALIVE");
                break;
            }
            for (int i = -X; i <= X; i++) {
                for (int j = -X; j <= X; j++) {
                    if (Math.abs(i) + Math.abs(j) <= X) {
                        int nx = cur.x + i;
                        int ny = cur.y + j;

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == map[cur.x][cur.y] && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            queue.add(new Point(nx, ny));
                        }
                    }
                }
            }
        }
        if (!isExit) {
            System.out.println("DEAD");
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
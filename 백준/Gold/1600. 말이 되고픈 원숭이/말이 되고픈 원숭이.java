import java.io.*;
import java.util.*;

public class Main {
    static int k, W, H;
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] jdx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] jdy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int idx = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        visited = new boolean[H][W][k+1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0, 0));
        visited[0][0][0] = true; // 아직 jump 안했을 때 경우 true
        int cnt = 0;
        boolean isExit = false;
        out:while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point cur = queue.poll();
                if (cur.x == H - 1 && cur.y == W - 1) {
                    isExit = true;
                    System.out.println(cnt);
                    break out;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                    if(visited[nx][ny][cur.jumpCnt]) continue;
                    if (arr[nx][ny] != 1) {
                        visited[nx][ny][cur.jumpCnt] = true;
                        queue.add(new Point(nx, ny, cur.jumpCnt));
                    }
                }
                if (cur.jumpCnt < k) {
                    for (int d = 0; d < 8; d++) {
                        int nx = cur.x + jdx[d];
                        int ny = cur.y + jdy[d];

                        if(nx < 0 || nx >= H || ny < 0 || ny >= W ) continue;
                        if(visited[nx][ny][cur.jumpCnt+1]) continue;
                        if (arr[nx][ny] != 1) {
                            visited[nx][ny][cur.jumpCnt+1] = true;
                            queue.add(new Point(nx, ny, cur.jumpCnt + 1));
                        }
                    }
                }
            }
            cnt++;
        }
        if (!isExit) {
            System.out.println(-1);
        }
    }
    public static class Point{
        int x;
        int y;
        int jumpCnt;

        public Point(int x, int y, int jumpCnt) {
            this.x = x;
            this.y = y;
            this.jumpCnt = jumpCnt;
        }
    }
}
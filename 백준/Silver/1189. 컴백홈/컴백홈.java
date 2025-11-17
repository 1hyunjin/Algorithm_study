import java.util.*;
import java.io.*;

public class Main {
    static int R, C, K;
    static char[][] map;
    static int cnt;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        cnt = 0;
        visited[R-1][0] = true;
        // 도착 지점은 0, C-1
        dfs(R - 1, 0, 1);
        System.out.println(cnt);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void dfs(int x, int y, int len) {
        if (x == 0 && y == C - 1) {
            if (len == K) {
                cnt++;
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'T' || visited[nx][ny]) {
                continue;
            }
            visited[nx][ny] = true;
            dfs(nx, ny, len + 1);
            visited[nx][ny] = false;
        }
    }
}
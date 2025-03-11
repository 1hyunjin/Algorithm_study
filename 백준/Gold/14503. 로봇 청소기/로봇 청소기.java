import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] cleaned;
    static int r, c, dir;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        cleaned = new boolean[n][m];
        int roomCnt = 0;
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            // 1.현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (map[r][c] == 0 && !cleaned[r][c]) {
                cleaned[r][c] = true; // 청소하면 2
                roomCnt++;
            }
            // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
            if (!notCleaned()) {
                // 후진하는 칸이 빈칸이면 후진, 후진하는 칸이 벽이면 종료
                if (!isGoBack()) {
                    break;
                }
            }
            // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 있는 경우
            else {
                // 반시계방향으로 회전
                rotate();
                go();
            }

        }
        System.out.println(roomCnt);
    }

    public static void go() {
        int nx = r;
        int ny = c;

        if (dir == 0) {
            nx -= 1;
        } else if (dir == 1) {
            ny += 1;
        } else if (dir == 2) {
            nx += 1;
        } else {
            ny -= 1;
        }
        if (nx >= 1 && nx < n - 1 && ny >= 1 && ny < m - 1 && map[nx][ny] == 0 && !cleaned[nx][ny]) {
            r = nx;
            c = ny;
        }
    }

    public static void rotate() {
        if (dir == 0) {
            dir = 3;
        } else if (dir == 1) {
            dir = 0;
        } else if (dir == 2) {
            dir = 1;
        } else {
            dir = 2;
        }
    }

    public static boolean isGoBack() {
        int nx = r;
        int ny = c;

        if (dir == 0) {
            nx += 1;
        } else if (dir == 1) {
            ny -= 1;
        } else if (dir == 2) {
            nx -= 1;
        } else {
            ny += 1;
        }
        if (map[nx][ny] == 1) {
            return false;
        } else {
            // 후진하셈
            r = nx;
            c = ny;
            return true;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static boolean notCleaned() {
        int cnt = 0;
        for (int d = 0; d < 4; d++) {
            int nx = r + dx[d];
            int ny = c + dy[d];

            if (nx >= 1 && nx < n - 1 && ny >= 1 && ny < m - 1 && map[nx][ny] == 0 && !cleaned[nx][ny]) {
                cnt++;
            }
        }
        // 4칸이 다 청소되어 있는 경우 -> false
        if (cnt == 0) {
            return false;
        }
        // 청소되지 않은 칸이 존재하면 -> true
        else {
            return true;
        }
    }
}

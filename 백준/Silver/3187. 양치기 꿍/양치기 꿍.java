import java.util.*;
import java.io.*;
public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        wolfCnt = 0;
        sheepCnt = 0;

        int vCnt = 0;
        int kCnt = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    wolfCnt = 0;
                    sheepCnt = 0;
                    dfs(i, j);
                    if (wolfCnt < sheepCnt) {
                        wolfCnt = 0;
                    }
                    else {
                        sheepCnt = 0;
                    }
                    vCnt += wolfCnt;
                    kCnt += sheepCnt;
                }
            }
        }

        System.out.println(kCnt + " " + vCnt);

    }
    static int wolfCnt;
    static int sheepCnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void dfs(int i, int j) {

        if (map[i][j] == 'v') {
            wolfCnt++;
        } else if (map[i][j] == 'k') {
            sheepCnt++;
        }

        visited[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != '#' && !visited[nx][ny]) {
                dfs(nx, ny);
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
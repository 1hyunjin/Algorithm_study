import java.util.*;
import java.io.*;

public class Main {
    static int[] result;
    static char[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        result = new int[7];

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        answer = 0;
        comb(0, 0);

        System.out.println(answer);
    }

    public static void comb(int cnt, int idx) {

        if (cnt == 7) {
            if (checkCnt(result)) {
                isConnect(result);
            }
            return;
        }
        for (int i = idx; i < 25; i++) {
            result[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

    public static boolean checkCnt(int[] result) {
        int som = 0;
        int yeon = 0;

        for (int i = 0; i < 7; i++) {
            int r = result[i] / 5;
            int c = result[i] % 5;

            if (map[r][c] == 'S') {
                som++;
            } else if (map[r][c] == 'Y') {
                yeon++;
            }
        }

        if (som >= 4 && yeon <= 3) {
            return true;
        }
        return false;
    }

    public static void isConnect(int[] result) {
        boolean[][] visited = new boolean[5][5];

        int[][] tmp = new int[5][5];

        for (int i = 0; i < 7; i++) {
            int r = result[i] / 5;
            int c = result[i] % 5;

            tmp[r][c] = 1;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (tmp[i][j] == 1 && !visited[i][j]) {
                    if(bfs(i, j, visited, tmp)){
                        answer++;
                    }
                }
            }
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static boolean bfs(int i, int j, boolean[][] visited, int[][] tmp) {

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(i, j));
        visited[i][j] = true;
        int cnt = 1;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nx][ny] && tmp[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    cnt++;
                }
            }
        }
        if (cnt == 7) {
            return true;
        }
        return false;
    }

    public static class Point {
        int x;
        int y;

        public Point(int i, int j) {
            this.x = i;
            this.y = j;
        }
    }
}
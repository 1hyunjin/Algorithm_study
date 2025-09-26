import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        cnt = 0;

        while (true) {
            visited = new boolean[12][6];
            List<List<Puyo>> groups = new ArrayList<>();
            for (int i = 11; i >= 0; i--) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        List<Puyo> list = findPuyo(i, j, map[i][j]);
                        if (list.size() >= 4) {
                            groups.add(list);
                        }
                    }
                }
            }
            if(groups.isEmpty()) break; // 터트릴 뿌요가 없으니까

            for (List<Puyo> list : groups) {
                for(Puyo p : list) map[p.x][p.y] = '.';
            }
            falling();
            cnt++;
        }
        System.out.println(cnt);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static List<Puyo> findPuyo(int x, int y, char val) {
        visited[x][y] = true;
        List<Puyo> list = new ArrayList<>();
        Queue<Puyo> queue = new ArrayDeque<>();
        queue.add(new Puyo(x, y));
        list.add(new Puyo(x, y));
        while (!queue.isEmpty()) {
            Puyo cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx < 0 || nx > 11 || ny < 0 || ny > 5 || visited[nx][ny] || map[nx][ny] != val) continue;
                queue.add(new Puyo(nx, ny));
                list.add(new Puyo(nx, ny));
                visited[nx][ny] = true;
            }
        }
        return list;
    }

    public static void falling() {
        for (int y = 0; y < 6; y++) {
            int floor = 11; // 바닥 인덱스 (아래에서부터 채워 넣기)
            for (int x = 11; x >= 0; x--) {
                if (map[x][y] != '.') {
                    char c = map[x][y];
                    map[x][y] = '.';
                    map[floor][y] = c;
                    floor--;
                }
            }
        }
    }
    public static class Puyo {
        int x;
        int y;

        public Puyo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
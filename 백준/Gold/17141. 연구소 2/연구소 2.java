import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<Point> list;
    static List<Point> wall;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        list = new ArrayList<>();
        wall = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    list.add(new Point(i, j));
                }
                // 벽인 애들 list에 담아놓기
                if (map[i][j] == 1) {
                    wall.add(new Point(i, j));
                }
            }
        }
        isSelected = new boolean[list.size()];
        ans = Integer.MAX_VALUE;

        comb(0, 0);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else System.out.println(ans);
    }

    public static void comb(int idx, int cnt) {
        if (cnt == M) {
            List<Point> result = new ArrayList<>();
            for (int i = 0; i < isSelected.length; i++) {
                if (isSelected[i]) {
                    result.add(new Point(list.get(i).i, list.get(i).j));
                }
            }
            makeTmp(result);
            return;
        }
        if (idx == list.size()) {
            return;
        }
        isSelected[idx] = true;
        comb(idx + 1, cnt + 1);
        isSelected[idx] = false;
        comb(idx + 1, cnt);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void makeTmp(List<Point> result){

        Queue<Point> queue = new ArrayDeque<>();
        int[][] tmp = new int[N][N];

        for (int i = 0; i < wall.size(); i++) {
            Point point = wall.get(i);
            tmp[point.i][point.j] = 1;
        }

        for (int i = 0; i < result.size(); i++) {
            Point virus = result.get(i);
            tmp[virus.i][virus.j] = 2;
            queue.add(new Point(virus.i, virus.j));
        }

        boolean[][] visited = new boolean[N][N];
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {

                Point cur = queue.poll();
                visited[cur.i][cur.j] = true;

                for (int d = 0; d < 4; d++) {
                    int nx = cur.i + dx[d];
                    int ny = cur.j + dy[d];

                    if(nx >= 0 && nx < N && ny >= 0 && ny < N
                        && tmp[nx][ny] == 0 && !visited[nx][ny] ){
                        visited[nx][ny] = true;
                        tmp[nx][ny] = 2;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
            time++;
        }
        // 바이러스가 다 퍼졌으면 ? 그 때의 시간을 기록
        if (checkSpread(tmp)) {
            ans = Math.min(ans, time-1);
        }
    }
    static int ans;
    public static boolean checkSpread(int[][] tmp) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tmp[i][j] == 0) {
                    cnt++;
                }
            }
        }
        if (cnt > 0) {
            return false;
        }
        else return true;
    }
    public static class Point{
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
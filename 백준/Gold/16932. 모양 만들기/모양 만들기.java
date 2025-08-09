import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int idx = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    list.add(new Point(i, j));
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = idx;
                    int total = bfs(i, j);
                    map.put(idx, total);
                    idx++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    int sum = 0;
                    Set<Integer> set = new HashSet<>();
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] != 0){
                            if(!set.contains(arr[nx][ny])){
                                sum+=map.get(arr[nx][ny]);
                                set.add(arr[nx][ny]);
                            }
                        }
                    }
                    sum+= 1;
                    max = Math.max(max, sum);
                }
            }
        }
        System.out.println(max);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));
        int cnt = 1;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M&& arr[nx][ny] == 1) {
                    queue.add(new Point(nx, ny));
                    arr[nx][ny] = idx;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
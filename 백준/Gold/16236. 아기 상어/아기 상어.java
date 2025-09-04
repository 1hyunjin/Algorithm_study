import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int result;
    static Queue<Shark> queue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;
        queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    visited[i][j] = true;
                    map[i][j] = 0;
                    queue.offer(new Shark(i, j));
                }
            }
        }
        bfs();
        System.out.println(result);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void bfs() {
        int babySize = 2;
        int feedCnt = 0;
        result = 0;

        PriorityQueue<Shark> pq = new PriorityQueue<>();
        int turn = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Shark cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                        if (map[nx][ny] != 0 && map[nx][ny] < babySize) {
                            // 먹을 수 있는거
                            pq.add(new Shark(nx, ny));
                        }
                        if (map[nx][ny] <= babySize) {
                            queue.add(new Shark(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            turn++;
            if (!pq.isEmpty()) {
                Shark cur = pq.poll(); // 먹을 수 있는거
                feedCnt++;
                map[cur.x][cur.y] = 0; // 먹었으니까
                if (feedCnt == babySize) {
                    babySize++;
                    feedCnt = 0;
                }
                result  = turn;
                pq.clear();
                queue.clear();
                visited = new boolean[N][N];
                queue.add(new Shark(cur.x, cur.y));
                visited[cur.x][cur.y] = true;
            }
        }
    }

    public static class Shark implements Comparable<Shark>{
        int x;
        int y;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Shark o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}
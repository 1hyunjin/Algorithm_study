import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] arr;
    static Map<String, List<Integer>> map;
    static List<Integer>[][] board;
    static Point[] info;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        board = new List[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); //0:흰, 1:빨, 2:파
                board[i][j] = new ArrayList<>();
            }
        }
        map = new HashMap<>();
        info = new Point[K + 1];
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken()); // 1(오), 2(왼), 3(위), 4(아래)

            info[i] = new Point(r, c, dir);
            board[r][c].add(i);
        }
        int turn = 0;

        while (turn < 1000) {
            turn++;

            for (int i = 1; i <= K; i++) {
                Point cur = info[i];

                int nx = cur.x + dx[cur.dir];
                int ny = cur.y + dy[cur.dir];

                // 파랑 & 밖
                if (nx <= 0 || nx > N || ny <= 0 || ny > N || arr[nx][ny] == 2) {
                    // 방향 바꿈
                    cur.dir = changeDir(cur.dir);
                    info[i].dir = cur.dir;

                    nx = cur.x + dx[cur.dir];
                    ny = cur.y + dy[cur.dir];

                    if (nx <= 0 || nx > N || ny <= 0 || ny > N || arr[nx][ny] == 2) {
                        continue;
                    }
                }
                List<Integer> curList = board[cur.x][cur.y];
                int idx = curList.indexOf(i);
                List<Integer> moving = new ArrayList<>(curList.subList(idx, curList.size()));
                board[cur.x][cur.y] = new ArrayList<>(curList.subList(0, idx));

                if (arr[nx][ny] == 1) {
                    Collections.reverse(moving);
                }
                board[nx][ny].addAll(moving);

                for (int v : moving) {
                    info[v].x = nx;
                    info[v].y = ny;
                }

                if (board[nx][ny].size() >= 4) {
                    System.out.println(turn);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    public static int changeDir(int dir) {
        if (dir == 1) return 2;
        else if (dir == 2) return 1;
        else if (dir == 3) return 4;
        else return 3;
    }

    public static class Point {
        int x;
        int y;
        int dir;

        public Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
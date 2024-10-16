import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int wateri, waterj, dooi, dooj;
    static int targeti, targetj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        wateri = 0;
        waterj = 0;

        dooi = 0;
        dooj = 0;

        wqueue = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '*') {
                    wqueue.add(new Point(i, j, 0));
                    visited[i][j] = true;
                }
                if (map[i][j] == 'S') {
                    dooi = i;
                    dooj = j;
                }
                if (map[i][j] == 'D') {
                    targeti = i;
                    targetj = j;
                }
            }
        }

        result = 0;

        bfs();

        if (isArrived) {
            System.out.println(result);
        } else {
            System.out.println("KAKTUS");
        }
    }

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int result;
    public static boolean isArrived;
    public static Queue<Point> wqueue;

    public static void bfs() {

        Queue<Point> dooqueue = new ArrayDeque<>();
        dooqueue.add(new Point(dooi, dooj, 0));    // 두더지 시작 좌표 집어넣기
        visited[dooi][dooj] = true;

        isArrived = false;

        out : while (!dooqueue.isEmpty()) {
//            print();
//            System.out.println("=============초기============");

            if (!wqueue.isEmpty()) {

                int size = wqueue.size();

                for (int s = 0; s < size; s++) {
                    Point wNow = wqueue.poll();

                    for (int d = 0; d < 4; d++) {

                        int wNexti = wNow.i + dx[d];
                        int wNextj = wNow.j + dy[d];

                        if (wNexti >= 0 && wNexti < R && wNextj >= 0 && wNextj < C) {   //&& !visited[wNexti][wNextj]
                            if (map[wNexti][wNextj] == '.' || map[wNexti][wNextj] == 'S') {
                                wqueue.add(new Point(wNexti, wNextj, wNow.dist + 1));
                                visited[wNexti][wNextj] = true;
                                map[wNexti][wNextj] = '*';   // 물로 바꿔
                            }
                        }
                    }
                }
            }
//            print();
//            System.out.println("==============물 끝=================");

            int dSize = dooqueue.size();
//            System.out.println(dooqueue);
            for (int s = 0; s < dSize; s++) {
                Point dNow = dooqueue.poll();

                for (int d = 0; d < 4; d++) {
                    int dNexti = dNow.i + dx[d];
                    int dNextj = dNow.j + dy[d];

                    if (dNexti == targeti && dNextj == targetj) {
                        isArrived = true;
                        result = dNow.dist + 1;
                        break out;
//                        return;
                    }

                    if (dNexti >= 0 && dNexti < R && dNextj >= 0 && dNextj < C
                            && map[dNexti][dNextj] == '.' && !visited[dNexti][dNextj]) {
                        dooqueue.add(new Point(dNexti, dNextj, dNow.dist + 1));
                        visited[dNexti][dNextj] = true;
                        map[dNexti][dNextj] = 'S';
                    }
                }
            }
//            print();
        }
    }

    public static class Point {
        int i, j;
        int dist;

        public Point(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    ", dist=" + dist +
                    '}';
        }
    }

    public static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("================");
    }
}
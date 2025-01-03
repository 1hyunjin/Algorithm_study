import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int bingo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[5][5];
        Map<Integer, Point> map = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                map.put(arr[i][j], new Point(i, j));
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }
        }

        // 사회자 부르는 수 차례대로 체킹해야 하는데? 빙고 개수도 확인해야한다.

        for (int i = 0; i < list.size(); i++) {

            int num = list.get(i);
            Point cur = map.get(num);
            arr[cur.x][cur.y] = -1;

            bingo = 0;

            // 가로
            garo();
            // 세로
            sero();
            // 대각선 1
            dae1();
            // 대각선 2
            dae2();

            if (bingo >= 3) {
                System.out.println(i+1);
                break;
            }
        }
    }

    public static void garo() {
        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == -1) {
                    cnt++;
                }
            }
            if (cnt == 5) {
                bingo++;
            }
        }
    }

    public static void sero() {
        for (int j = 0; j < 5; j++) {
            int cnt = 0;
            for (int i = 0; i < 5; i++) {
                if (arr[i][j] == -1) {
                    cnt++;
                }
            }
            if (cnt == 5) {
                bingo++;
            }
        }
    }

    public static void dae1() {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[i][i] == -1) {
                cnt++;
            }
            if (cnt == 5) {
                bingo++;
            }
        }
    }

    public static void dae2() {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[i][4 - i] == -1) {
                cnt++;
            }
            if (cnt == 5) {
                bingo++;
            }
        }
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] isCheck;
    static HashMap<Integer, Point> map;
    static int bingo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[5][5];
        isCheck = new boolean[5][5];

        map = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                map.put(arr[i][j], new Point(i, j));
            }
        }
        bingo = 0;
        int cnt = 1;
        out:for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                Point cur = map.get(num);
                isCheck[cur.x][cur.y] = true;
                if (cnt >= 5) {
                    bingo = 0;
                    // 열 확인
                    checkRow();
                    // 행 확인
                    checkCol();
                    // 대각선 확인
                    checkDae1();
                    checkDae2();

                    if (bingo >= 3) {
                        System.out.println(cnt);
                        break out;
                    }
                }
                cnt++;
            }
        }
    }
    public static void checkRow() {
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if(!isCheck[i][j]){
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                bingo++;
            }
        }
    }
    public static void checkCol() {
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (!isCheck[j][i]) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                bingo++;
            }
        }
    }
    public static void checkDae1() {
        boolean isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (!isCheck[i][i]) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) {
            bingo++;
        }
    }
    public static void checkDae2() {
        boolean isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (!isCheck[i][4 - i]) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) {
            bingo++;
        }
    }
    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "Point { " + this.x + " , " + this.y + " }";
        }
    }
}

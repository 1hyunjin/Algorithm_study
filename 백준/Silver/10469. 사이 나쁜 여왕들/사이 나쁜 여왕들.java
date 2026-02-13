import java.io.*;
import java.util.*;

class Main {
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[8][8];
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '*') {
                    cnt++;
                }
            }
        }
        boolean flag = true;
        if (cnt != 8) {
            System.out.println("invalid");
            return;
        }
        out:for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] == '*') {
                    if (!check(i, j)) {
                        flag = false;
                        break out;
                    }
                }
            }
        }
        if (flag) {
            System.out.println("valid");
        }
        else{
            System.out.println("invalid");
        }
    }

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, +1};
    static int[] dy = {0, 0, -1, 1, -1, +1, -1, +1};

    public static boolean check(int x, int y) {
        for (int d = 0; d < 8; d++) {
            int nx = x;
            int ny = y;

            while (true) {
                nx += dx[d];
                ny += dy[d];

                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) {
                    break;
                }
                if (map[nx][ny] == '*') {
                    return false;
                }
            }
        }
        return true;
    }
}
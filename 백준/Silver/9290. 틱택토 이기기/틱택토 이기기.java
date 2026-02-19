import java.io.*;
import java.util.*;

class Main {
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        map = new char[3][3];
        for (int t = 0; t < T; t++) {
            sb.append("Case").append(" ").append(t + 1).append(":").append('\n');
            for (int i = 0; i < 3; i++) {
                String s = br.readLine();
                for (int j = 0; j < 3; j++) {
                    map[i][j] = s.charAt(j);
                }
            }
            char c = br.readLine().charAt(0);
            out:for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (map[i][j] == '-') {
                        map[i][j] = c;
                        if (tic(i, j, c)) {
                            for (int k = 0; k < 3; k++) {
                                for (int l = 0; l < 3; l++) {
                                    sb.append(map[k][l]);
                                }
                                sb.append('\n');
                            }
                            break out;
                        }
                        map[i][j] = '-';
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean tic(int x, int y, char c) {
        int cnt = 0;
        // 가로
        for (int i = 0; i < 3; i++) {
            cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == c) {
                    cnt++;
                }
            }
            if (cnt == 3) {
                return true;
            }
        }
        // 세로
        for (int i = 0; i < 3; i++) {
            cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (map[j][i] == c) {
                    cnt++;
                }
            }
            if (cnt == 3) {
                return true;
            }
        }
        // 대각선1
        cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (map[i][i] == c) {
                cnt++;
            }
        }
        if (cnt == 3) {
            return true;
        }
        // 대각선2
        cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (map[i][2 - i] == c) {
                cnt++;
            }
        }
        if (cnt == 3) {
            return true;
        }

        return false;
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static Set<Integer> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            map = new int[9][9];
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean isCorrect = true;
            out: for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if(!square(i, j)){
                        isCorrect = false;
                        break out;
                    }
                    if (!garo(i)) {
                        isCorrect = false;
                        break out;
                    }
                    if (!sero(j)) {
                        isCorrect = false;
                        break out;
                    }
                }
            }
            if (isCorrect) {
                sb.append("Case ").append(t + 1).append(": CORRECT").append("\n");
            }
            else{
                sb.append("Case ").append(t + 1).append(": INCORRECT").append("\n");
            }
            if (t < T - 1) {
                br.readLine();
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean square(int x, int y) {
        int rx = (x / 3) * 3;
        int ry = (y / 3) * 3;
        set = new HashSet<>();
        for (int i = rx; i < rx + 3; i++) {
            for (int j = ry; j < ry + 3; j++) {
                set.add(map[i][j]);
            }
        }
        if (set.size() == 9) {
            return true;
        }
        return false;
    }

    public static boolean garo(int x) {
        set = new HashSet<>();
        for (int j = 0; j < 9; j++) {
            set.add(map[x][j]);
        }
        if (set.size() == 9) {
            return true;
        }
        return false;
    }

    public static boolean sero(int y) {
        set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set.add(map[i][y]);
        }
        if (set.size() == 9) {
            return true;
        }
        return false;
    }
}
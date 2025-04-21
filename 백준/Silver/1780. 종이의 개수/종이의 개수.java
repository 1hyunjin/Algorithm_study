import java.io.*;
import java.util.*;

public class Main {
    static int m, z, o;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        m = 0;
        z = 0;
        o = 0;

        func(0, 0, N);
        System.out.println(m);
        System.out.println(z);
        System.out.println(o);

    }

    public static void func(int x, int y, int N) {
        boolean flag = true;
        out:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[x][y] != map[x + i][y + j]) {
                    flag = false;
                    break out;
                }
            }
        }
        if (flag) {
            if (map[x][y] == -1) {
                m++;
            } else if (map[x][y] == 0) {
                z++;
            } else o++;
        } else {
            for (int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++){
                    func(x + (i*N/3), y + (j*N/3), N/3);
                }
            }
        }
    }
}

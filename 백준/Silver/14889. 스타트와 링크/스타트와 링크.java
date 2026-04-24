import java.io.*;
import java.util.*;

class Main {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < (1 << N); i++) {
            if (Integer.bitCount(i) != N / 2) continue;
            int start = 0;
            int link = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if ((i & (1 << j)) != 0 && ((i & (1 << k)) != 0)) {
                        start += (map[j][k]);
                    }
                    else if ((i & (1 << j)) == 0 && ((i & (1 << k)) == 0)) {
                        link += (map[j][k]);
                    }
                }
            }
            int cha = Math.abs(start - link);
            min = Math.min(min, cha);
        }
        System.out.println(min);
    }
}
import java.io.*;
import java.util.*;

class Main {
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (arr[j] == 'H') {
                    map[i][j] = 0;  // H -> 0
                } else {
                    map[i][j] = 1;  // T -> 1
                }
            }
        }
        // 행 조합
        for (int mask = 0; mask < (1 << N); mask++) {
            int totalT = 0;
            // 열 고정
            for (int j = 0; j < N; j++) {
                int top = 0;
                for (int i = 0; i < N; i++) {
                    int value = map[i][j];
                    if ((mask & (1 << i)) != 0) { // 뒤집힌 행이라면
                        value = 1-value; // 뒤집기 0 -> 1, 1 -> 0
                    }
                    if (value == 1) {
                        top++;
                    }
                }
                // T가 많으면 뒤집는게 이득
                totalT += Math.min(top, N - top);
            }
            min = Math.min(min, totalT);
        }
        System.out.println(min);
    }
}
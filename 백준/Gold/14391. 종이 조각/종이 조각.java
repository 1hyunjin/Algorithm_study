import java.io.*;
import java.util.*;

class Main {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = cArr[j] - '0';
            }
        }
        int max = 0;
        for (int mask = 0; mask < (1 << (N * M)); mask++) {
            int sum = 0;
            // 가로 = 비트가 1인 경우
            for (int i = 0; i < N; i++) {
                int num = 0;
                for (int j = 0; j < M; j++) {
                    int idx = i*M + j;
                    if ((mask & (1 << idx)) != 0) {
                        num = num*10 + map[i][j];
                    }
                    else{
                        sum += num;
                        num = 0;
                    }
                }
                sum += num;
            }
            // 세로 = 비트가 0인 경우
            for (int j = 0; j < M; j++) {
                int num = 0;
                for (int i = 0; i < N; i++) {
                    int idx = i*M + j;
                    if ((mask & (1 << idx)) == 0) {
                        num = num*10 + map[i][j];
                    }
                    else{
                        sum += num;
                        num = 0;
                    }
                }
                sum += num;
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
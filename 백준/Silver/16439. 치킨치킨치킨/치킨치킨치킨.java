import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] result;
    static int[][] arr;
    static int max_sum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = new int[3];
        max_sum = 0;
        comb(0, 1);
        System.out.println(max_sum);
    }

    public static void comb(int cnt, int idx) {
        if (cnt == 3) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int max =0;
                for (int j = 0; j < 3; j++) {
                    int type = result[j];
                    max = Math.max(max, arr[i][type]);
                }
                sum += max;
            }
            max_sum = Math.max(max_sum, sum);
            return;
        }
        if (idx == M + 1) {
            return;
        }
        result[cnt] = idx;
        comb(cnt+1, idx+1);
        comb(cnt, idx+1);
    }
}
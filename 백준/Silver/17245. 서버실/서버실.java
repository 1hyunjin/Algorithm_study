import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] map = new int[N][N];
        long end = 0;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                end = Math.max(end, map[i][j]);
                sum += map[i][j];
            }
        }

        long start = 0;
        long min = Long.MAX_VALUE;
        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] <= mid) {
                        cnt += map[i][j];
                    } else {
                        cnt += mid;
                    }
                }
            }
            if (cnt*2 >= sum) {
                min = Math.min(min, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(min);

    }
}
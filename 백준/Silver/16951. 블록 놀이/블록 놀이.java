import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int[] tmp = new int[N + 1];
            tmp[i] = arr[i];

            boolean flag = false;
            for (int j = i - 1; j > 0; j--) {
                tmp[j] = tmp[j + 1] - K;
                if (tmp[j] <= 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (int j = i + 1; j <= N; j++) {
                    tmp[j] = tmp[j - 1] + K;
                }
                int cnt = 0;
                for (int j = 1; j <= N; j++) {
                    if (arr[j] != tmp[j]) {
                        cnt++;
                    }
                }
                min = Math.min(min, cnt);
            }
        }
        System.out.println(min);
    }
}
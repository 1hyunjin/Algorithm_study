import java.io.*;
import java.util.*;

class Main {
    static int[] arr;
    static int N, S, cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cnt = 0;
        if (S == 0) {
            cnt = -1;
        }
        back(0, 0);
        System.out.println(cnt);
    }

    public static void back(int idx, int result) {
        if (idx == N) {
            if (result == S) {
                cnt++;
            }
            return;
        }
        back(idx + 1, result + arr[idx]);
        back(idx+1, result);
    }
}
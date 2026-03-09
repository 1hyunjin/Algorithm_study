import java.io.*;
import java.util.*;

class Main {
    static int N, S, cnt;
    static int[] arr;
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
        comb(0, 0);
        if (S == 0) {
            cnt--;
        }
        System.out.println(cnt);
    }

    public static void comb(int result, int idx) {
        if (idx== N) {
            if (result == S) {
                cnt++;
            }
            return;
        }
        comb(result + arr[idx], idx + 1);
        comb(result, idx+1);
    }
}
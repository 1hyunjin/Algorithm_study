import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num % 2 == 0) {
                arr[i] = true;
            } else {
                arr[i] = false;
            }
        }

        int l = 0;
        int r = 0;
        int maxLen = 0;
        int cnt = 0;

        while (r < N) {
            if (cnt < K) {
                if (!arr[r]) {
                    cnt++;
                }
                r++;
                maxLen = Math.max(maxLen, r - l - cnt);
            } else if (cnt == K && arr[r]) {
                r++;
                maxLen = Math.max(maxLen, r - l - cnt);
            } else if (cnt == K && !arr[r]) {
                if (!arr[l]) {
                    cnt--;
                }
                l++;
            }
        }
        System.out.println(maxLen);
    }
}
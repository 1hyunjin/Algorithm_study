import java.io.*;
import java.util.*;

public class Main {
    static int N, K, M;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int kimbap = Integer.parseInt(br.readLine());
            if (kimbap >= 2 * K) {
                if (kimbap - (2 * K) > 0) {
                    list.add(kimbap - (2 * K));
                }
            } else if (kimbap > K) {
                list.add(kimbap - K);
            }
        }
        long ans = -1;
        long s = 1;
        long e = 1000000000;
        while (s <= e) {
            long mid = (s + e + 1) / 2;
            if (cut(mid)) {
                ans = Math.max(ans, mid);
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean cut(long mid) {
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i) / mid;
        }
        return sum >= M;
    }
}

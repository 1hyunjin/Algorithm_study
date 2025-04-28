import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        friends = new int[N];
        for (int i = 0; i < N; i++) {
            friends[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(friends);
        long start = 0;
        long end = friends[N - 1];

        while (start < end) {
            long mid = (start + end + 1) / 2;

            if (share(mid)) {
                start = mid;
            }
            else {
                end = mid-1;
            }
        }
        System.out.println(start);

    }

    public static boolean share(long mid) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            cnt += friends[i]/mid;
        }
        if (cnt >= K) {
            return true;
        }
        return false;
    }
}
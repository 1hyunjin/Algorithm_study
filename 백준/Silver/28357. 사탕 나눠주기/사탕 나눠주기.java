import java.io.*;
import java.util.*;

public class Main {
    static long[] arr;
    static int N;
    static long K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        long s = 0;
        long e = 0;
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long a = Long.parseLong(st.nextToken());
            arr[i] = a;
            e = Math.max(e, a);
        }
        long ans = Long.MAX_VALUE;
        while (s <= e) {
            long mid = (s+e)/2;
            if (getX(mid)) {
                ans = Math.min(ans, mid);
                e =mid-1;
            }
            else{
                s = mid+1;
            }
        }
        System.out.println(ans);
    }

    public static boolean getX(long mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > mid) {
                sum+=arr[i]-mid;
            }
        }
        if (sum <= K) {
            return true;
        }
        return false;
    }
}
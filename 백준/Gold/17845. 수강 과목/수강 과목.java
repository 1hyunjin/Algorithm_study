import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Point[] arr = new Point[K+1];
        int[] dp = new int[N+1];
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i <= K; i++) {
            for (int j = N; j >= arr[i].T; j--) {
                if (j >= arr[i].T) {
                    dp[j] = Math.max(dp[j], dp[j - arr[i].T] + arr[i].I);
                }
            }
        }
        System.out.println(dp[N]);
    }
    public static class Point{
        int I;
        int T;

        public Point(int I, int T) {
            this.I = I;
            this.T = T;
        }
    }
}
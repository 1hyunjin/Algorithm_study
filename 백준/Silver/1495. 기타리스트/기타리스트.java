import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] dp = new int[M+1];
        Arrays.fill(dp, -1);
        int[] volume = new int[N+1];
        for (int i = 1; i <= N; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }
        dp[S] = 0;
        for (int i = 1; i <= N; i++) {
            int vol = volume[i];
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= M; j++) {
                if(dp[j] == i-1){
                    int add = j+vol;
                    if (add <= M) {
                        list.add(add);
                    }
                    int minus = j-vol;
                    if (minus >= 0) {
                        list.add(minus);
                    }
                }
            }
            for (int v : list) {
                dp[v] = i;
            }
        }
        int max = -1;
        for (int i = 0; i <= M; i++) {
            if (dp[i] == N) {
                max = Math.max(max, i);
            }
        }
        System.out.println(max);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N+1];
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer>[] graph= new List[N+1];
            for (int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            int[] cnt = new int[N+1];
            int[] dp = new int[N+1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                cnt[b]++;
            }
            int target = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                if (cnt[i] == 0) {
                    queue.offer(i);
                    dp[i] = arr[i];
                }
            }
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int v : graph[cur]) {
                    dp[v] = Math.max(dp[v], dp[cur] + arr[v]);
                    cnt[v]--;
                    if (cnt[v] == 0) {
                        queue.offer(v);
                    }
                }
            }
            sb.append(dp[target]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
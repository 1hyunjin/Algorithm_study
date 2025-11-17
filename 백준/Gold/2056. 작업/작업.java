import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new List[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] arr = new int[N+1]; // 시간 저장 배열
        int[] prev = new int[N+1]; // 선행 개수 저장 배열
        int[] result = new int[N+1]; // 시간 과정 저장 배열
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
             st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int preCnt = Integer.parseInt(st.nextToken());
            if (preCnt > 0) {
                for (int j = 0; j < preCnt; j++) {
                    int v = Integer.parseInt(st.nextToken());
                    graph[v].add(i);
                }
            }
            arr[i] = time;
            prev[i] = preCnt;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (prev[i] == 0) {
                queue.offer(i);
                result[i] = arr[i];
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                prev[next]--;
                result[next] = Math.max(result[next], result[cur] + arr[next]);
                if (prev[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, result[i]);
        }
        System.out.println(max);
    }
}
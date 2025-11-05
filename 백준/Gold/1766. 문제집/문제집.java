import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        List<Integer>[] list = new List[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            arr[b]++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1-o2);
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) {
                queue.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for (int v : list[cur]) {
                arr[v]--;
                if (arr[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        List<Integer>[] graph= new List[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        int[] arr = new int[N+1];
        Arrays.fill(arr, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(a);
        arr[a] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for(int v : graph[cur]){
                if (arr[v] == -1) {
                    arr[v] = arr[cur]+1;
                    queue.add(v);
                }
            }
        }
        System.out.println(arr[b]);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean isPossible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        isPossible = false;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            dfs(i,1);
            if (isPossible) {
                break;
            }
        }
        System.out.println(isPossible?1:0);
    }

    public static void dfs(int start, int cnt) {
        if (cnt == 5) {
            isPossible = true;
            return;
        }

        for (int next : graph[start]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, cnt+1);
                visited[next] = false;
            }
        }
    }
}
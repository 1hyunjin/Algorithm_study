import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static int[][] dp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점의 개수
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        dp = new int[N+1][2];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        // 트리 구조이기 때문에 1부터 시작
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    public static void dfs(int num) {
        visited[num] = true;
        dp[num][0] = 0; // 해당 num이 얼리어답터가 아닌 경우
        dp[num][1] = 1; // 해당 num이 얼리어답터인 경우 (우선 시작 시 해당 지점이 얼리어답터이므로 개수는 1)

        for (int child : graph[num]) {
            // dfs 중복 방문 방지
            if(!visited[child]){
                dfs(child); // dfs 재귀호출을 통해 자식 노드의 dp 값을 미리 구한다.
                dp[num][0] += dp[child][1]; // 자식 노드가 무조건 얼리어답터여야 한다.
                dp[num][1] += Math.min(dp[child][0], dp[child][1]); // 최소의 얼리어답터 인원을 뽑아야하므로 자식 노드가 얼리어답터 일수도, 아닐수도 있다.
            }
        }
    }
}

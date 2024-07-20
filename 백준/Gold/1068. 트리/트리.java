import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, removeIndex, cnt;
    static List[] adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new List[N];
        visited = new boolean[N];
        int root = 0;

        for (int v = 0; v < N; v++) {
            adj[v] = new ArrayList<>();
        }
        cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int v1 = Integer.parseInt(st.nextToken());
            if (v1 == -1) {
                root = i;
            }
            else {
                adj[v1].add(i);
            }
        }
        removeIndex = Integer.parseInt(br.readLine());
        dfs(root);
        System.out.println(cnt);
    }

    public static void dfs(int cur) {
        // 최상위root가 지워졌을 때
        if (cur == removeIndex) {
            return;
        }
        // 최상위 root에서 자식이 하나 있을 경우에 그 자식이 removeIndex일 때 
        if (adj[cur].size() == 1 && (Integer)adj[cur].get(0) == removeIndex) {
            cnt++;
            return;
        }
        visited[cur] = true;
        if(adj[cur].size() == 0) {
            cnt++;
        }
        else {
            for (int n : (ArrayList<Integer>)adj[cur]){
                if (n != removeIndex) {
                    if (!visited[n]) {
                        dfs(n);
                    }
                }
            }
        }
    }
}
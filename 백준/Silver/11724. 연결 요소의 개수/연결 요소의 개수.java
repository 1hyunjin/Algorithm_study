import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List[] arrList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrList = new List[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < arrList.length; i++) {
            arrList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arrList[u].add(v);
            arrList[v].add(u);
        }

//		for (int i = 0; i < arrList.length; i++) {
//			System.out.println(arrList[i]);
//		}
        int cnt = 0;
        for (int i = 1; i < arrList.length; i++) {
            if(!visited[i]) {
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    public static void bfs(int num) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(num);
        visited[num] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i = 0; i < arrList[cur].size(); i++) {
                int v = (int) arrList[cur].get(i);
                if(!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }
    }
}
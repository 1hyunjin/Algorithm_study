import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        bfs(N);
    }

    public static void bfs(int N) {
        visited[N] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int cur = queue.poll();
                if (cur == K) {
                    System.out.println(time);
                    return;
                }
                int l = cur - 1;
                int r = cur + 1;
                int jump = 2 * cur;
                if (l >= 0 && !visited[l]) {
                    queue.offer(l);
                    visited[l] = true;
                }
                if (r <= 100000 && !visited[r]) {
                    queue.offer(r);
                    visited[r] = true;
                }
                if (jump <= 100000 && !visited[jump]) {
                    queue.offer(jump);
                    visited[jump] = true;
                }
            }
            time++;
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        if (N == K) {
            answer = 0;
        } else {
            bfs(N);
        }

        System.out.println(answer);
    }

    public static void bfs(int N) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(N);
        visited[N] = true;

        int time = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int s = 0; s < size; s++) {

                int cur = queue.poll();
                int left = cur - 1;
                int right = cur + 1;
                int jump = cur * 2;

                if (left >= 0 && !visited[left]) {
                    queue.add(left);
                    visited[left] = true;
                }
                if (right <= 100000 && !visited[right]) {
                    queue.add(right);
                    visited[right] = true;
                }
                if (jump <= 100000 && !visited[jump]) {
                    queue.add(jump);
                    visited[jump] = true;
                }

                if (left == K || right == K || jump == K) {
                    queue.removeAll(queue);
                    break;
                }
            }
            time++;
            answer++;
        }
    }

}
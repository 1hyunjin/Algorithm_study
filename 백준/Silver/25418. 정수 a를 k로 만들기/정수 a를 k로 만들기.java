import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[1000001];
        queue.add(A);
        visited[A] = true;
        int turn = 0;


        out:while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                Integer cur = queue.poll();
                if (cur == K) {
                    System.out.println(turn);
                    break out;
                }

                int next1 = cur+1;
                int next2 = cur*2;

                if (next1 <= K && !visited[next1]) {
                    queue.add(next1);
                    visited[next1] = true;
                }
                if (next2 <= K && !visited[next2]) {
                    queue.add(next2);
                    visited[next2] = true;
                }
//                System.out.println(queue);
            }
            turn++;
        }
    }
}

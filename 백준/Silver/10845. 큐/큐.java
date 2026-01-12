import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            switch (op) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    queue.offer(x);
                    break;
                case "pop":
                    if (!queue.isEmpty()) {
                        sb.append(queue.poll()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if (!queue.isEmpty()) {
                        sb.append(queue.peek()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "back":
                    int num = -1;
                    if (!queue.isEmpty()) {
                        num = queue.peekLast();
                    }
                    sb.append(num).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
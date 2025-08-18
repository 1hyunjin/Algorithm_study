import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if (op == 2) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            } else if (op == 3) {
                if (!deque.isEmpty()) {
                    sb.append(deque.pollFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (op == 4) {
                if (!deque.isEmpty()) {
                    sb.append(deque.pollLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (op == 5) {
                sb.append(deque.size()).append("\n");
            } else if (op == 6) {
                if (deque.isEmpty()) {
                    sb.append(1).append("\n");
                } else{
                    sb.append(0).append('\n');
                }
            } else if (op == 7) {
                if (!deque.isEmpty()) {
                    sb.append(deque.peekFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else {
                if (!deque.isEmpty()) {
                    sb.append(deque.peekLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dequeue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dequeue.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            Integer cur = dequeue.pollFirst();
            sb.append(cur).append(" ");
            if (dequeue.isEmpty()) {
                break;
            }
            Integer move = dequeue.pollFirst();
            dequeue.offerLast(move);
        }
        System.out.println(sb.toString());
    }
}
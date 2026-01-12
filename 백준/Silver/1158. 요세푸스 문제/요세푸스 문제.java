import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deq.offer(i);
        }
        while (true) {
            if (deq.size() == 1) {
                sb.append(deq.poll()).append(">");
                break;
            }
            for (int n = 1; n < K; n++) {
                int num = deq.pollFirst();
                deq.offerLast(num);
            }
            sb.append(deq.pollFirst()).append(",").append(" ");
        }
        System.out.println(sb.toString());
    }
}
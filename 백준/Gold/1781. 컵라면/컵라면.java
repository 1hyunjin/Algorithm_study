import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr = new int[N+1];
        PriorityQueue<Problem> pq1 = new PriorityQueue<>((o1, o2) -> o1.deadLine - o2.deadLine);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            pq1.offer(new Problem(deadLine, cnt));
        }
        PriorityQueue<Problem> pq2 = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);

        while (!pq1.isEmpty()) {
            Problem cur = pq1.poll();
            if (pq2.size() < cur.deadLine) {
                pq2.offer(cur);
            } else if (!pq2.isEmpty() && pq2.size() == cur.deadLine) {
                if (pq2.peek().cnt < cur.cnt) {
                    pq2.poll();
                    pq2.offer(cur);
                }
            }
        }
        int sum = 0;
        while (!pq2.isEmpty()) {
            sum += pq2.poll().cnt;
        }
        System.out.println(sum);
    }
    public static class Problem{
        int deadLine;
        int cnt;

        public Problem(int deadLine, int cnt) {
            this.deadLine = deadLine;
            this.cnt = cnt;
        }
    }
}
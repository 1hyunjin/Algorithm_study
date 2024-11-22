import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            PriorityQueue<Long> pq = new PriorityQueue<>();

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long answer = 0;

            while (pq.size() > 1) {
                long num1 = pq.poll();
                long num2 = pq.poll();
                answer += num1 + num2;
                pq.offer(num1+num2);
            }

            System.out.println(answer);
        }
    }
}
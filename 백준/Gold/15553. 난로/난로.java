import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());
        int prev = start;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (Integer.compare(o2, o1)));
        for (int i = 1; i < N; i++) {
            int time = Integer.parseInt(br.readLine());
            pq.offer(time - (prev+1));
            prev = time;
        }
        int sum  = 0;
        for (int i = 0; i < K - 1; i++) {
            sum += pq.poll();
        }
        System.out.println((prev - start + 1) - sum);
    }
}
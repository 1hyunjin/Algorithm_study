import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken()); // 범위
        Deque<int[]> deq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!deq.isEmpty() && deq.peekLast()[0] > num) {
                deq.pollLast();
            }
            deq.offer(new int[]{num, i});
            if (deq.peek()[1] < i - (L - 1)) { // 범위 밖의 인덱스면 poll
                deq.poll();
            }
            bw.write(deq.peek()[0] + " ");
        }
        bw.flush();
        bw.close();
    }
}
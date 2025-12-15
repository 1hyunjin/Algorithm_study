import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] b = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] c = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                deq.addLast(b[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            deq.addFirst(c[i]);
            sb.append(deq.pollLast()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
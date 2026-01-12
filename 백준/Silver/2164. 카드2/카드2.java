import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deq.offer(i);
        }
        while (!deq.isEmpty()) {
            if (deq.size() == 1) {
                System.out.println(deq.poll());
            }
            deq.pollFirst();
            if (!deq.isEmpty()) {
                int num = deq.pollFirst();
                deq.offerLast(num);
            }
        }
    }
}
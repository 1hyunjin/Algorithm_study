import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int n = 0; n < N; n++) {
            int num = Integer.parseInt(br.readLine());
            if (min.size() == max.size()) {
                max.offer(num);
            }
            else{
                min.offer(num);
            }
            if (!max.isEmpty() && !min.isEmpty()) {
                if (max.peek() > min.peek()) {
                    int tmp = max.poll();
                    max.offer(min.poll());
                    min.offer(tmp);
                }
            }
            sb.append(max.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
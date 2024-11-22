import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 0) {
                pq.offer(num);
            }
            else {
                if (pq.isEmpty()) {
                    sb.append(0).append('\n');
                }
                else{
                    sb.append(pq.poll()).append('\n');
                }
            }
        }
        System.out.println(sb.toString());
    }
}
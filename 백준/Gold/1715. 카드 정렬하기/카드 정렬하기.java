import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.offer(num);
        }

        int sum = 0;

        while (pq.size() > 1) {
            Integer a = pq.poll();
            Integer b = pq.poll();

            int x = a+b;
            sum += x;
            pq.offer(x);
        }

        System.out.println(sum);
    }
}
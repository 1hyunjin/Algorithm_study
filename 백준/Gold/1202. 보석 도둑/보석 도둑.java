import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewels> pq = new PriorityQueue<>(new Comparator<Jewels>(){
            @Override
            public int compare(Jewels o1, Jewels o2) {
                if (o1.v == o2.v) {
                    return o1.m - o2.m;
                }
                return o2.v - o1.v;
            }
        });
        PriorityQueue<Jewels> jems = new PriorityQueue<>((o1, o2) -> o1.m - o2.m);
        PriorityQueue<Integer> bags = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jems.offer(new Jewels(m, v));
        }
        for (int i = 0; i < K; i++) {
            int m = Integer.parseInt(br.readLine());
            bags.offer(m);
        }
        long sum = 0;
        while (!bags.isEmpty()) {
            Integer bag = bags.poll();
            while (!jems.isEmpty()) {
                if(bag < jems.peek().m) break;
                pq.offer(jems.poll());
            }
            if(!pq.isEmpty()){
                sum += pq.poll().v;
            }
        }

        System.out.println(sum);
    }
    public static class Jewels{
        int m;
        int v;

        public Jewels(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}
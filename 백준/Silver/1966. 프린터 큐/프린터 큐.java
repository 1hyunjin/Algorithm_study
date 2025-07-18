import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서 개수
            int M = Integer.parseInt(st.nextToken()); // 위치

            Deque<Point> deq = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
                @Override
                public int compare(Integer a, Integer b) {
                    return b-a;
                }
            });
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int level = Integer.parseInt(st.nextToken());
                deq.add(new Point(level, i));
                pq.add(level);
            }
            int cnt =0;
            while (!deq.isEmpty()) {
                Point cur = deq.pollFirst();
                if (cur.level == pq.peek()) {
                    pq.poll();
                    cnt++;
                    if (cur.idx == M) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                }
                else{
                    deq.addLast(cur);
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static class Point {
        int level;
        int idx;

        public Point(int level, int idx) {
            this.level = level;
            this.idx = idx;
        }
    }
}
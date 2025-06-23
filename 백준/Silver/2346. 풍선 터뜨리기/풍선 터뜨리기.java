import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Point> deq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            deq.addLast(new Point(i + 1, Integer.parseInt(st.nextToken())));
        }
        StringBuilder sb = new StringBuilder();
        while (!deq.isEmpty()) {
            Point cur = deq.pollFirst();
            sb.append(cur.num).append(" ");
            if(deq.isEmpty()) break;
            int turn = cur.move-1;

            if (cur.move > 0) { // 양수면?
                for (int i = 0; i < turn; i++) {
                    Point next = deq.pollFirst();
                    deq.addLast(next);
                }
            }
            else{ // 음수면?
                for (int i = 0; i < Math.abs(cur.move); i++) {
                    Point next = deq.pollLast();
                    deq.addFirst(next);
                }
            }
        }
        System.out.println(sb.toString());
    }
    public static class Point{
        int num;
        int move;

        public Point(int num, int move) {
            this.num = num;
            this.move = move;
        }
    }
}
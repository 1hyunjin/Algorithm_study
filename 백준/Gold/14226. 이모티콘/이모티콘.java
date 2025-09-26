import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        int emoticon = 1;
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 1, 0));
        // 1 : 복사, 2 : 붙여넣기 . 3:삭제
        int time = 0;
        boolean[][] visited = new boolean[1001][1001];
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.total == S) {
                System.out.println(cur.time);
                break;
            }
            queue.offer(new Point(cur.total, cur.total, cur.time + 1));

            if (cur.clipboard != 0 && cur.total + cur.clipboard <= S && !visited[cur.clipboard][cur.total + cur.clipboard]) {
                queue.offer(new Point(cur.clipboard, cur.total + cur.clipboard, cur.time + 1));
                visited[cur.clipboard][cur.clipboard+cur.total] = true;
            }
            if (cur.total >= 1 && !visited[cur.clipboard][cur.total - 1]) {
                queue.offer(new Point(cur.clipboard, cur.total - 1, cur.time + 1));
                visited[cur.clipboard][cur.total-1] = true;
            }

        }
    }

    public static class Point {
        int clipboard;
        int total;
        int time;

        public Point(int clipboard, int total, int time) {
            this.clipboard = clipboard;
            this.total = total;
            this.time = time;
        }
    }
}
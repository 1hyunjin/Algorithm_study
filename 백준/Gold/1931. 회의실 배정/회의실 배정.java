import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Point[] rooms = new Point[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rooms[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int cnt = 0;
        int before =0;
        Arrays.sort(rooms);
        for (int i = 0; i < N; i++) {
            if (before <= rooms[i].start) {
                cnt++;
                before = rooms[i].end;
            }
        }
        System.out.println(cnt);
    }
    public static class Point implements Comparable<Point>{
        int start;
        int end;

        public Point(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Point o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}

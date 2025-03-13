import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int INF = Integer.MAX_VALUE;

        int[] arr = new int[D + 1];
        Arrays.fill(arr, INF);

        Point[] shortCut = new Point[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            shortCut[i] = new Point(start, end, dist);
        }

        Arrays.sort(shortCut, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return p1.start - p2.start;
            }
        });

        arr[0] = 0;
        int nowDist = 0;
        int idx = 0;

        while (nowDist < D) {

            while (idx < N) {
                if (shortCut[idx].start != nowDist) {
                    break;
                }
                if (shortCut[idx].end <= D) {
                    int shortDist = arr[nowDist] + shortCut[idx].dist;
                    if (arr[shortCut[idx].end] > shortDist ) {
                        arr[shortCut[idx].end] = shortDist;
                    }
                }
                idx++;
            }
            // 1씩 증가
            if (arr[nowDist+1] > arr[nowDist] + 1) {
                arr[nowDist+1] = arr[nowDist] + 1;
            }
            nowDist++;
        }
        System.out.println(arr[D]);
    }

    public static class Point {
        int start;
        int end;
        int dist;

        public Point(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }
}

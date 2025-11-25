import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[3][3];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int sx = 0;
        int sy = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sb.append(map[i][j]);
                if (map[i][j] == 0) {
                    sx = i;
                    sy = j;
                }
            }
        }
        String init = sb.toString();
        Queue<Point> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Point(sx, sy, init));
        visited.add(init);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point cur = queue.poll();
                if (cur.s.equals("123456780")) {
                    System.out.println(cnt);
                    return;
                }
                int curIdx = 3* cur.x + cur.y;
                String curStr = cur.s;
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx < 0 || nx > 2 || ny < 0 || ny > 2) continue;
                    int nIdx = 3*nx + ny;
                    char[] arr = curStr.toCharArray();
                    char tmp = arr[curIdx];
                    arr[curIdx] = arr[nIdx];
                    arr[nIdx] = tmp;
                    String nStr = new String(arr);

                    if (visited.contains(nStr)) {
                        continue;
                    }
                    visited.add(nStr);
                    queue.offer(new Point(nx, ny, nStr));
                }
            }
            cnt++;
        }
        System.out.println(-1);

    }

    public static class Point {
        int x;
        int y;
        String s;

        public Point(int x, int y, String s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }
}
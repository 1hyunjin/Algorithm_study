import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Point> queue = new ArrayDeque<>();

        queue.add(new Point(0, 0));
        visited[0][0] = true;
        boolean isArrived = false;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.x == N - 1 && cur.y == N - 1) {
                isArrived = true;
                break;
            }
            int move = map[cur.x][cur.y];

            int nx = cur.x + move;
            int ny = cur.y + move;

            if (nx < N && cur.y < N && !visited[nx][cur.y]) {
                queue.add(new Point(nx, cur.y));
                visited[nx][cur.y] = true;
            }
            if (ny < N && cur.x < N && !visited[cur.x][ny]) {
                queue.add(new Point(cur.x, ny));
                visited[cur.x][ny]= true;
            }
        }
        if (isArrived) {
            System.out.println("HaruHaru");
        }
        else{
            System.out.println("Hing");
        }
    }
    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y =  y;
        }
        @Override
        public String toString() {
            return "Point{ " + this.x + " , " + this.y + " }";
        }
    }
}
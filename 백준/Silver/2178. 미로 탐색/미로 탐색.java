import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] =  str.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(visited[N-1][M-1]);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void bfs() {
        visited[0][0] = 1;
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0,0));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 1){

                    if (visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[cur.x][cur.y] + 1;
                        queue.add(new Point(nx, ny));
                    }
                    else if(visited[nx][ny] > visited[cur.x][cur.y]+1){
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = visited[cur.x][cur.y] + 1;
                    }
                }
            }
        }
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x =x ;
            this.y = y;
        }
    }
}

import java.util.*;
import java.io.*;
public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static Point[] targets;
    static int[][] targetOrder;
    static long cnt;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        targets = new Point[m];
        targetOrder = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(targetOrder[i], -1);
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            targets[i] = new Point(x, y);
            targetOrder[x][y] = i;
        }
        // for(int i = 1; i <= n; i++){
        //     for(int j = 1; j <= n; j++){
        //         System.out.print(targetOrder[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        visited = new boolean[n+1][n+1];
        int sx = targets[0].x;
        int sy = targets[0].y;
        visited[sx][sy] = true; // 첫번째 방문 지점 true 해주고
        cnt = 0;
        dfs(sx, sy, 1); // x, y, 지점 방문 갯수
        System.out.println(cnt);
    }
    
    public static void dfs(int x, int y, int nextTarget){
        if(nextTarget == m){
            cnt++;
            return;
        }

        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 1 || nx > n || ny < 1 || ny > n || map[nx][ny] == 1 || visited[nx][ny]){
                continue;
            }
            int order = targetOrder[nx][ny];
            int newNextTarget = nextTarget;

            if(order != -1){    // 필수 방문지라면?
                if(order != nextTarget){    // 순서가 안맞으면 continue;
                    continue;
                }
                // 올바른 다음 지점을 방문함
                newNextTarget++;
            }
            visited[nx][ny] = true;
            dfs(nx, ny, newNextTarget);
            visited[nx][ny] = false; // 원상 복구
        }
    }

    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString(){
            return "Point{" + this.x + " , " + this.y + "}";
        }
    }
}
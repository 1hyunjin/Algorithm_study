import java.util.*;
import java.io.*;

public class Main {
    static int N, M, G, R;
    static int[][] garden;
    static List<Integer> list;
    static int[] result;
    static int[] green;
    static int[] red;
    static boolean[] isSelected;
    static int max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        garden = new int[N][M];
        list = new ArrayList<>();
        result = new int[R+G];
        green = new int[G];
        red = new int[R];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                garden[i][j] = Integer.parseInt(st.nextToken());
                if(garden[i][j] == 2){
                    list.add(i*M+j);
                }
            }
        }
        // 조합으로 R+G 만큼 뽑기
        comb(0, 0);
        System.out.println(max);
    }

    public static void comb(int idx, int cnt) {
        if(cnt == R+G){
            // G 개수만큼 고르기 (booealn을 써야 안받은거 확인할 수 있음)
            isSelected = new boolean[R+G];
            pickGreen(0,0, result);
            return;
        }
        if (idx == list.size()) {
            return;
        }

        result[cnt] = list.get(idx);
        comb(idx+1, cnt+1);
        comb(idx+1, cnt);
    }
    static List<Integer> gList;
    static List<Integer> rList;

    public static void pickGreen(int idx, int cnt, int[] result) {
        if(cnt == G){
            gList = new ArrayList<>();
            rList = new ArrayList<>();
            for (int i = 0; i < R + G; i++) {
                if (isSelected[i]) {
                    gList.add(result[i]);
                }
                else {
                    rList.add(result[i]);
                }
            }
            bfs();
            return;
        }
        if(idx == R+G){
            return;
        }
        isSelected[idx] = true;
        pickGreen(idx+1, cnt+1, result);
        isSelected[idx] = false;
        pickGreen(idx+1, cnt, result);
    }
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] ac;
    static char[][] colors;
    public static void bfs() {
        visited = new boolean[N][M];
        ac = new int[N][M];
        colors = new char[N][M];

        int access = 2; // 그냥 처음 비교를 위해서 (접근 비교)
        Queue<Point> queue = new ArrayDeque<>();
        for (int g : gList) {
            int x = g/M;
            int y = g%M;
            queue.offer(new Point(x, y, 'G'));
            visited[x][y] = true;
            ac[x][y] = 1;
            colors[x][y] = 'G';
        }
        for (int r : rList) {
            int x = r/M;
            int y = r%M;
            queue.offer(new Point(x, y, 'R'));
            visited[x][y] = true;
            ac[x][y] = 1;
            colors[x][y] = 'R';
        }

        int flower = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point cur = queue.poll();
                if(ac[cur.x][cur.y] == -1) continue;
                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && garden[nx][ny] != 0) {
                        // 만약 이미 visited 된 칸이라면? 같은 초에 접근했는지를 확인
                        if (visited[nx][ny]) {
                            if(ac[nx][ny] == access ){
                                if((cur.color == 'G' && colors[nx][ny] == 'R') || (cur.color == 'R' && colors[nx][ny] == 'G')){
                                    flower++;
                                    ac[nx][ny] = -1; // 꽃 생김
                                }
                            }
                        }
                        else{
                            visited[nx][ny] = true;
                            ac[nx][ny] = access;
                            colors[nx][ny] = cur.color;
                            queue.offer(new Point(nx, ny, cur.color));
                        }
                    }
                }
            }
            access++;
        }
        max = Math.max(max, flower);
    }
    public static class Point{
        int x;
        int y;
        char color;

        public Point(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
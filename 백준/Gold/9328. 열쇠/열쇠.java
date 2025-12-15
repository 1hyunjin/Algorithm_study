import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int h, w, cnt;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] hasKey;
    static List<Point>[] waiting;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h+2][w+2];
            for (int i = 0; i <=h+1; i++) {
                for(int j = 0; j <= w+1; j++ ){
                    map[i][j] = '.';
                }
            }
            for (int i = 1; i <= h; i++) {
                String s = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = s.charAt(j-1);
                }
            }
            String keys = br.readLine();
            hasKey = new boolean[26];
            if(!keys.equals("0")){
                for (int i = 0; i < keys.length(); i++) {
                    hasKey[keys.charAt(i) - 'a'] = true;
                }
            }

            visited = new boolean[h+2][w+2];
            waiting = new List[26];
            for (int i = 0; i < 26; i++) {
                waiting[i] = new ArrayList<>();
            }
            cnt = 0;
            bfs(0, 0);
            System.out.println(cnt);
        }
    }

    public static void bfs(int i, int j) {
        visited[0][0] = true;
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0));
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx > h + 1 || ny < 0 || ny > w + 1 || visited[nx][ny] || map[nx][ny] == '*') {
                    continue;
                }
                char c = map[nx][ny];
                if(Character.isUpperCase(c)){
                    // 문을 만났어. 그럼 key를 확인해야지.
                    if(hasKey[c-'A']){
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                    else{
                        waiting[c - 'A'].add(new Point(nx, ny));
                    }
                }
                else if (Character.isLowerCase(c)) {
                    int k = c-'a';
                    if (!hasKey[k]) {
                        hasKey[k] =true;
                        for(Point p : waiting[k]){
                            visited[p.x][p.y] = true;
                            queue.offer(p);
                        }
                        waiting[k].clear();
                    }
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
                else if(map[nx][ny] == '.'){
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
                else if(map[nx][ny] == '$'){
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
    }
    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
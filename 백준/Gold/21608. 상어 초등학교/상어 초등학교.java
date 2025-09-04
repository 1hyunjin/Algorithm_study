import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, result;
    static int[][] map;
    static PriorityQueue<Point> pq;
    static Map<Integer, Set<Integer>> students;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        students = new HashMap<>();
        result = 0;
        pq = new PriorityQueue<>(new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.friendCnt == o2.friendCnt) {
                    if (o1.blankCnt == o2.blankCnt) {
                        if (o1.x == o2.x) {
                            return o1.y - o2.y;
                        }
                        return o1.x - o2.x;
                    }
                    return o2.blankCnt - o1.blankCnt;
                }
                return o2.friendCnt - o1.friendCnt;
            }
        });
        StringTokenizer st;
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            students.put(num, set);
            findPlace(num);
        }
        getScore();
        System.out.println(result);
    }
    public static void getScore(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = map[i][j];
                int cnt = 0;
                Set<Integer> favor = students.get(num);
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (favor.contains(map[nx][ny])) {
                        cnt++;
                    }
                }
                if(cnt == 1) result+=1;
                else if(cnt == 2) result+=10;
                else if(cnt == 3) result+=100;
                else if(cnt == 4) result+=1000;
            }
        }
    }
    public static void findPlace(int num) {
        Set<Integer> favor = students.get(num);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int blankCnt = 0;
                int friendCnt = 0;

                if(map[i][j] != 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nx = i+dx[d];
                    int ny = j+dy[d];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    if(map[nx][ny] == 0){
                        blankCnt++;
                    }
                    if (favor.contains(map[nx][ny])) {
                        friendCnt++;
                    }
                    pq.offer(new Point(i, j, blankCnt, friendCnt));
                }
            }
        }
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            map[cur.x][cur.y] = num;
            pq.clear();
        }
    }
    public static class Point{
        int x;
        int y;
        int blankCnt;
        int friendCnt;

        public Point(int x, int y, int blankCnt, int friendCnt) {
            this.x = x;
            this.y = y;
            this.blankCnt = blankCnt;
            this.friendCnt = friendCnt;
        }
    }
}
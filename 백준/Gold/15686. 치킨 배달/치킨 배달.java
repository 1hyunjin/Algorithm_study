import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[] visited;
    static List<Point> house;
    static List<Point> chicken;
    static List<Point> select;
    static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        select = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
                if (map[i][j] == 1) {
                    house.add(new Point(i, j));
                }
            }
        }
        result = Integer.MAX_VALUE;

        visited = new boolean[chicken.size()];
        comb(0, 0);
        System.out.println(result);
    }

    public static void comb(int idx, int cnt) {
        if (cnt == M) {
            select = new ArrayList<>();

            for (int i = 0; i < chicken.size(); i++) {
                if (visited[i]) {
                    select.add(chicken.get(i));
                }
            }
            result = Math.min(result, findDistance(select));
            return;
        }
        if (idx == chicken.size()) {
            return;
        }

        visited[idx] = true;
        comb(idx+1, cnt+1);
        visited[idx] = false;
        comb(idx + 1, cnt);
    }

    public static int findDistance(List<Point> select) {
        int sum = 0;
        for (int i = 0; i < house.size(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < select.size(); j++) {
                int dist = Math.abs(house.get(i).x - select.get(j).x) + Math.abs(house.get(i).y - select.get(j).y);
                min = Math.min(min, dist);
            }
            sum += min;
        }
        return sum;
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
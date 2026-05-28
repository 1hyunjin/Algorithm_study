import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt, max;
    static int[][] map;
    static int[][] tmp;
    static List<Point> list;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        cnt = 0;
        map = new int[N][N];
        list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    list.add(new Point(i, j));
                    cnt++;
                }
            }
        }

        arr = new int[cnt];
        max = 0;
        perm(0);
        System.out.println(max);
    }
    public static void perm(int idx){
        if(idx == cnt){
            bomb(arr);
            return;
        }
        for(int i = 1; i <= 3; i++){
            arr[idx] = i;
            perm(idx+1);
        }
    }
    public static void bomb(int[] arr){
        tmp  = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                tmp[i][j] = map[i][j];
            }
        }
        for(int i = 0; i < cnt; i++){
            Point cur = list.get(i);
            int op = arr[i];

            if(op == 1){
                upDown(cur);
            }
            else if(op == 2){
                udlr(cur);
            }
            else {
                daegak(cur);
            }
        }
        count(tmp);
    }
    public static void count(int[][] tmp){
        int v = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(tmp[i][j] == 1){
                    v++;
                }
            }
        }
        max = Math.max(max, v);
    }
    public static void daegak(Point cur){
        int x = cur.x;
        int y = cur.y;
        int[] dx = {-1,-1,1,1};
        int[] dy = {-1,1,-1,1};
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            tmp[nx][ny] = 1;
        }
    }
    public static void udlr(Point cur){
        int x = cur.x;
        int y = cur.y;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            tmp[nx][ny] = 1;
        }
    }

    public static void upDown(Point cur){
        int x = cur.x;
        int y = cur.y;

        int[] dx = {-1,1};
        for(int d = 0; d < 2; d++){
            for(int i = 1; i <= 2; i++){
                int nx = x + dx[d]*i;
                if(d == 0 && nx >= 0){
                    tmp[nx][y] = 1;
                }
                if(d == 1 && nx < N){
                    tmp[nx][y] = 1;
                }
            }
        }
    }
    public static class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
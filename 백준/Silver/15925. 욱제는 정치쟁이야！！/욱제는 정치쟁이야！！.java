import java.io.*;
import java.util.*;

class Main {
    static int N, order;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        order = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check();
        check();
        boolean isMatch = true;
        out:for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != order) {
                    isMatch = false;
                    break out;
                }
            }
        }
        if(isMatch){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
    public static void check() {
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (map[i][j] == order) {
                    cnt++;
                }
            }
            if (cnt > (N / 2)) {
                for (int k = 0; k < N; k++) {
                    map[i][k] = order;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (map[j][i] == order) {
                    cnt++;
                }
            }
            if (cnt > (N / 2)) {
                for (int k = 0; k < N; k++) {
                    map[k][i]= order;
                }
            }
        }
    }
}
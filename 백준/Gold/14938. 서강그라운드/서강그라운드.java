import java.util.*;
import java.io.*;

public class Main {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[][] map = new long[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], INF);
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            if (map[a][b] > len) {
                map[a][b] = len;
            }
            if (map[b][a] > len) {
                map[b][a] = len;
            }
        }
        for (int i = 1; i <= n; i++) {
            map[i][i] = 0;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        int max = 0;

        for (int i = 1; i <= n; i++) {
            int itemCnt  = 0;
            for (int j = 1; j <= n; j++) {
                if (map[i][j] <= m) {
                    itemCnt+=arr[j];
                }
            }
            max = Math.max(max, itemCnt);
        }
        System.out.println(max);
    }
}
import java.io.*;
import java.util.*;


public class Main {
    static int[][] arr;
    static int[][] prefix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        prefix = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                prefix[i][j] = Integer.parseInt(st.nextToken()) + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int sum = getPrefixSum(x1, y1, x2, y2);
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int getPrefixSum(int x1, int y1, int x2, int y2) {
        return prefix[x2][y2] - prefix[x2][y1-1] - prefix[x1-1][y2] + prefix[x1-1][y1-1];
    }
}